package com.Dpaper.app;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
			// Define the search term
		String searchQuery = "Notebook";

		// Instantiate the client
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);

		// Set up the URL with the search term and send the request
		String searchUrl = "https://newyork.craigslist.org/search/sss?query=" + URLEncoder.encode(searchQuery, "UTF-8");
		HtmlPage page = client.getPage(searchUrl);
List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//li[@class='result-row']");
if (!items.isEmpty()) {
  // Iterate over all elements
  for (HtmlElement item : items) {

    // Get the details from <p class="result-info"><a href=""></a></p>
    HtmlAnchor itemAnchor = ((HtmlAnchor) htmlItem.getFirstByXPath(".//p[@class='result-info']/a"));

    // Get the price from <a><span class="result-price"></span></a>
    HtmlElement spanPrice = ((HtmlElement) htmlItem.getFirstByXPath(".//a/span[@class='result-price']")) ;

    String itemName = itemAnchor.asText()
    String itemUrl =  itemAnchor.getHrefAttribute()

    // It is possible that an item doesn't have any price
    String itemPrice = spanPrice == null ? "0.0" : spanPrice.asText() ;

    System.out.println( String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));

  }
}
else {
  System.out.println("No items found !");
}
		
	}

}
