var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20000",
        "ok": "20000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2923",
        "ok": "2923",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "632",
        "ok": "632",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "626",
        "ok": "626",
        "ko": "-"
    },
    "percentiles1": {
        "total": "426",
        "ok": "426",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1006",
        "ok": "1006",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1694",
        "ok": "1697",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2549",
        "ok": "2549",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 13589,
        "percentage": 68
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 2349,
        "percentage": 12
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4062,
        "percentage": 20
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1250",
        "ok": "1250",
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
        "total": "20000",
        "ok": "20000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2923",
        "ok": "2923",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "632",
        "ok": "632",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "626",
        "ok": "626",
        "ko": "-"
    },
    "percentiles1": {
        "total": "426",
        "ok": "426",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1006",
        "ok": "1006",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1693",
        "ok": "1694",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2549",
        "ok": "2549",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 13589,
        "percentage": 68
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 2349,
        "percentage": 12
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4062,
        "percentage": 20
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1250",
        "ok": "1250",
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
