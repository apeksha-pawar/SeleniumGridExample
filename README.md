# SeleniumGridExample
* Illustrated example of selenium grid (nodes are present on same machine) with commandline and with JSON file.
* Here are commands to register hub and node using command line - 

* Register Hub : 
java -jar selenium-server-standalone-3.141.59.jar -port 4441 -role hub

* Register node :
java -Dwebdriver.gecko.driver="E:\Self-Automation\geckodriver.exe" -jar selenium-server-standalone-3.141.59 -role webdriver -hub http://localhost:4441/grid/register -port 5566

* Here are commands to register hub and node using JSON file -
* Register Hub :
java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubconfig.json

* Register node :
Java -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.ie.driver="IEDriverServer.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig nodeconfig.json -port 5566/5567/5568
