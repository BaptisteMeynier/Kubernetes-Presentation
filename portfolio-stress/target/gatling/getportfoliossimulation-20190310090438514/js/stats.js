var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "10000",
        "ok": "10000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2518",
        "ok": "2518",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "501",
        "ok": "501",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "438",
        "ok": "438",
        "ko": "-"
    },
    "percentiles1": {
        "total": "522",
        "ok": "522",
        "ko": "-"
    },
    "percentiles2": {
        "total": "803",
        "ok": "803",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1086",
        "ok": "1086",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2068",
        "ok": "2068",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 7462,
        "percentage": 75
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 2237,
        "percentage": 22
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 301,
        "percentage": 3
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "833.333",
        "ok": "833.333",
        "ko": "-"
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
        "ok": "10000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2518",
        "ok": "2518",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "501",
        "ok": "501",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "438",
        "ok": "438",
        "ko": "-"
    },
    "percentiles1": {
        "total": "522",
        "ok": "522",
        "ko": "-"
    },
    "percentiles2": {
        "total": "803",
        "ok": "803",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1086",
        "ok": "1086",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2068",
        "ok": "2068",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 7462,
        "percentage": 75
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 2237,
        "percentage": 22
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 301,
        "percentage": 3
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "833.333",
        "ok": "833.333",
        "ko": "-"
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
