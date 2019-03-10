var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "10000",
        "ok": "0",
        "ko": "10000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "2755",
        "ok": "-",
        "ko": "2755"
    },
    "meanResponseTime": {
        "total": "926",
        "ok": "-",
        "ko": "926"
    },
    "standardDeviation": {
        "total": "821",
        "ok": "-",
        "ko": "821"
    },
    "percentiles1": {
        "total": "868",
        "ok": "-",
        "ko": "868"
    },
    "percentiles2": {
        "total": "1607",
        "ok": "-",
        "ko": "1607"
    },
    "percentiles3": {
        "total": "2275",
        "ok": "-",
        "ko": "2275"
    },
    "percentiles4": {
        "total": "2373",
        "ok": "-",
        "ko": "2373"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 10000,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1666.667",
        "ok": "-",
        "ko": "1666.667"
    }
},
contents: {
"req_get-all-portfol-1a968": {
        type: "REQUEST",
        name: "Get all portfolios",
path: "Get all portfolios",
pathFormatted: "req_get-all-portfol-1a968",
stats: {
    "name": "Get all portfolios",
    "numberOfRequests": {
        "total": "10000",
        "ok": "0",
        "ko": "10000"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "2755",
        "ok": "-",
        "ko": "2755"
    },
    "meanResponseTime": {
        "total": "926",
        "ok": "-",
        "ko": "926"
    },
    "standardDeviation": {
        "total": "821",
        "ok": "-",
        "ko": "821"
    },
    "percentiles1": {
        "total": "868",
        "ok": "-",
        "ko": "867"
    },
    "percentiles2": {
        "total": "1607",
        "ok": "-",
        "ko": "1607"
    },
    "percentiles3": {
        "total": "2275",
        "ok": "-",
        "ko": "2275"
    },
    "percentiles4": {
        "total": "2373",
        "ok": "-",
        "ko": "2373"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 10000,
        "percentage": 100
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1666.667",
        "ok": "-",
        "ko": "1666.667"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
