var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "5000",
        "ok": "4334",
        "ko": "666"
    },
    "minResponseTime": {
        "total": "9",
        "ok": "78",
        "ko": "9"
    },
    "maxResponseTime": {
        "total": "18755",
        "ok": "18755",
        "ko": "1600"
    },
    "meanResponseTime": {
        "total": "8883",
        "ok": "10072",
        "ko": "1143"
    },
    "standardDeviation": {
        "total": "4828",
        "ok": "4031",
        "ko": "381"
    },
    "percentiles1": {
        "total": "9018",
        "ok": "10024",
        "ko": "1272"
    },
    "percentiles2": {
        "total": "12329",
        "ok": "13033",
        "ko": "1460"
    },
    "percentiles3": {
        "total": "16109",
        "ok": "16168",
        "ko": "1584"
    },
    "percentiles4": {
        "total": "18623",
        "ok": "18665",
        "ko": "1596"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 3,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 14,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4317,
        "percentage": 86
    },
    "group4": {
        "name": "failed",
        "count": 666,
        "percentage": 13
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "250",
        "ok": "216.7",
        "ko": "33.3"
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
        "total": "5000",
        "ok": "4334",
        "ko": "666"
    },
    "minResponseTime": {
        "total": "9",
        "ok": "78",
        "ko": "9"
    },
    "maxResponseTime": {
        "total": "18755",
        "ok": "18755",
        "ko": "1600"
    },
    "meanResponseTime": {
        "total": "8883",
        "ok": "10072",
        "ko": "1143"
    },
    "standardDeviation": {
        "total": "4828",
        "ok": "4031",
        "ko": "381"
    },
    "percentiles1": {
        "total": "9017",
        "ok": "10036",
        "ko": "1272"
    },
    "percentiles2": {
        "total": "12329",
        "ok": "13033",
        "ko": "1460"
    },
    "percentiles3": {
        "total": "16109",
        "ok": "16168",
        "ko": "1584"
    },
    "percentiles4": {
        "total": "18623",
        "ok": "18665",
        "ko": "1596"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 3,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 14,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4317,
        "percentage": 86
    },
    "group4": {
        "name": "failed",
        "count": 666,
        "percentage": 13
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "250",
        "ok": "216.7",
        "ko": "33.3"
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
