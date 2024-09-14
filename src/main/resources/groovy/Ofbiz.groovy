package groovy

def test = binding.getVariable('test')
def shell = new GroovyShell()
shell.evaluate(test);
def requestMethod = request.getMethod()
println "Request method: ${requestMethod}"

return "Hello from test.groovy! Test parameter: ${test}"
