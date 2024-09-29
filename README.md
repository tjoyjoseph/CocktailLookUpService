
# Cocktail Lookup
## A lookup for all of your cocktails needs

### About

Cocktail Lookup is a RESTFul service that provides you the ability to search for any cocktails of the 1000 
cocktails we have. You can look it up by name or by letter. The service even provides you 
the ability get instructions on how to make them delicious cocktails of your choosing, but remember.. 
drink responsibility!

One of the benefits of the service is that it provides caching for a day. This means that while the service is
still running you can look up cocktails, and if you ever lose connection you are still able to search cocktails you have 
searched before.

### Instructions
1. Open up command line (windows) / terminal (windows)
2. Go to the project directory e.g. `cd ~/cocktaillookup`
3. Type command to build the app
   4. **Windows** - `mvnw package`
   5. **Mac** `./mvnw package`
6. Wait for the build to finish successfully
7. Type to run the app -`java -jar target/cocktaillookup-0.0.1-SNAPSHOT.jar`

### Services
After running the application, you can use the following services:

- **Looking up via name**
http://localhost:8080/getCocktails?name=margarita

- **Looking up via letter**
http://localhost:8080/getCocktails?name=m

- **Getting cocktail instructions**
http://localhost:8080/getCocktailInstructions?name=margarita

**Note**: the application uses Java OpenJDK-19


