package com.cursosdedesarrollo.app;
import geb.spock.GebSpec

class MyBaseTest extends GebSpec {
    def "search 'Groovy Browser Automation' in duckduckgo"() {
        given: "we are on the duckduckgo search-engine"
        go "https://duckduckgo.com"

        when: "we search for 'Groovy Browser Automation'"
        $("#search_form_homepage").q = "Groovy Browser Automation"
        $("#search_button_homepage").click()

        then: "the first result (excluding ads) is the geb website"
        $("#links").$(".nrn-react-div a", 0).attr("href") == "http://www.gebish.org/"
    }
}