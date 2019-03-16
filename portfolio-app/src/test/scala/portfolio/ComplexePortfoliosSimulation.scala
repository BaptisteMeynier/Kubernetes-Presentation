package portfolio

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ComplexePortfoliosSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080/api/v1/portfolio") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")


  val csvFeeder = csv("data/portfolios.csv") // use a comma separator

  val jsonTemplate = """{ "code": "${code}","amount":${amount},"devise":"${devise}","manager":"${manager}" }"""


  val search = http("Get portfolio") // let's give proper names, as they are displayed in the reports
    .get("/${code}")
    .check(status.is(200))
    .check(jsonPath("$..code").ofType[String].is("${code}"))

  val doesNotFind = http("Get portfolio") // let's give proper names, as they are displayed in the reports
    .get("/${code}")
    .check(status.is(404))

  val insert = http("Insert portfolio")
    .post("")
    .body(StringBody(jsonTemplate)).asJson
    .header("Content-Type", "application/json")
    .check(status.is(200))
    .check(bodyString.is("true"))


  val delete = exec(http("Delete portfolio")
    .delete("/${code}")
    .check(status.is(200))
    .check(bodyString.is("true"))
  )


  val scn = scenario("Complexe Scenario")
    .feed(csvFeeder.circular)
    .exec(insert)
    .pause(1)
    .exec(search)
    .pause(1)
    .exec(delete)
    .pause(1)
    .exec(doesNotFind)


  setUp(scn.inject(atOnceUsers(10)).protocols(httpProtocol))
}