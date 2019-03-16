package portfolio

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class SmoothieGetPortfoliosSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080/api/v1/portfolio") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Get portfolios") // A scenario is a chain of requests and pauses
    .exec(http("Get all portfolios")
    .get("?page=1&per_page=5000"))

  setUp(scn.inject(rampUsers(5000) during (5 minutes)).protocols(httpProtocol))
}