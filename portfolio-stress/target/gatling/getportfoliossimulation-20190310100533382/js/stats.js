var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "10000",
        "ok": "5175",
        "ko": "4825"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "7",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "14558",
        "ok": "14558",
        "ko": "3403"
    },
    "meanResponseTime": {
        "total": "4273",
        "ok": "7435",
        "ko": "881"
    },
    "standardDeviation": {
        "total": "4747",
        "ok": "4678",
        "ko": "1002"
    },
    "percentiles1": {
        "total": "1935",
        "ok": "8006",
        "ko": "501"
    },
    "percentiles2": {
        "total": "8350",
        "ok": "11886",
        "ko": "1283"
    },
    "percentiles3": {
        "total": "12933",
        "ok": "13242",
        "ko": "3043"
    },
    "percentiles4": {
        "total": "13407",
        "ok": "13710",
        "ko": "3310"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 513,
        "percentage": 5
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 208,
        "percentage": 2
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4454,
        "percentage": 45
    },
    "group4": {
        "name": "failed",
        "count": 4825,
        "percentage": 48
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "500",
        "ok": "258.75",
        "ko": "241.25"
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
        "ok": "5175",
        "ko": "4825"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "7",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "14558",
        "ok": "14558",
        "ko": "3403"
    },
    "meanResponseTime": {
        "total": "4273",
        "ok": "7435",
        "ko": "881"
    },
    "standardDeviation": {
        "total": "4747",
        "ok": "4678",
        "ko": "1002"
    },
    "percentiles1": {
        "total": "1934",
        "ok": "8013",
        "ko": "501"
    },
    "percentiles2": {
        "total": "8349",
        "ok": "11886",
        "ko": "1283"
    },
    "percentiles3": {
        "total": "12933",
        "ok": "13242",
        "ko": "3043"
    },
    "percentiles4": {
        "total": "13407",
        "ok": "13710",
        "ko": "3310"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 513,
        "percentage": 5
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 208,
        "percentage": 2
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4454,
        "percentage": 45
    },
    "group4": {
        "name": "failed",
        "count": 4825,
        "percentage": 48
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "500",
        "ok": "258.75",
        "ko": "241.25"
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
