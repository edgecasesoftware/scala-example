package uk.co.edgecasesoftware.service

case class HttpConfig(host:String, port:String)
case class ServiceConfig(systemName:String, http:HttpConfig)

class ServiceMonitor {

}
