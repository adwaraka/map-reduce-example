README
~~~~~~
This code is an example of MapReduce. The code is executed using the BigInsights framework. 
The following is the format of the input files:-

125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Nokia_E52 HTTP/1.1" Canada 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Samsung_CorbyPlus HTTP/1.1" Germany 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Nokia_E52 HTTP/1.1" Canada 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Samsung_Galaxy HTTP/1.1" India 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Nokia_N8 HTTP/1.1" China 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Apple_iPhone4 HTTP/1.1" India 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Apple_iPhone4 HTTP/1.1" China 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Samsung_Galaxy HTTP/1.1" India 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Apple_iPhone4 HTTP/1.1" Spain 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=HTC_Trophy HTTP/1.1" Spain 200 2345
125.125.125.125 2010-12-17 08:00:00 "GET /product/productDetails?productID=Nokia_N8 HTTP/1.1" US 200 2345
...


NOTE: This just counts sales of individual cell models. Other than that, there is no formal analysis as such! 

However, you can customize the main code by adding set function. Like 
conf.set("Option",args[0]);
conf.set("Param", args[1]);
..

And then accept these values in the mapper by using
Configuration conf = context.getConfiguration();
String option = conf.get("Option");
String p = conf.get("Param");
...

Feel free to use the code anyway you wish and perform various analysis!!
