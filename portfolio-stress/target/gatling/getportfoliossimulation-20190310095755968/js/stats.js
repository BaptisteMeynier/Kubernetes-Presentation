var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20000",
        "ok": "4222",
        "ko": "15778"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "45",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "19179",
        "ok": "19179",
        "ko": "18764"
    },
    "meanResponseTime": {
        "total": "9681",
        "ok": "11423",
        "ko": "9215"
    },
    "standardDeviation": {
        "total": "5819",
        "ok": "4652",
        "ko": "6009"
    },
    "percentiles1": {
        "total": "11345",
        "ok": "12117",
        "ko": "10980"
    },
    "percentiles2": {
        "total": "14550",
        "ok": "14713",
        "ko": "14535"
    },
    "percentiles3": {
        "total": "17712",
        "ok": "18509",
        "ko": "17488"
    },
    "percentiles4": {
        "total": "18721",
        "ok": "19084",
        "ko": "18449"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 27,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 20,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4175,
        "percentage": 21
    },
    "group4": {
        "name": "failed",
        "count": 15778,
        "percentage": 79
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "666.667",
        "ok": "140.733",
        "ko": "525.933"
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
        "ok": "4222",
        "ko": "15778"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "45",
        "ko": "0"
    },
    "maxResponseTime": {
        "total": "19179",
        "ok": "19179",
        "ko": "18764"
    },
    "meanResponseTime": {
        "total": "9681",
        "ok": "11423",
        "ko": "9215"
    },
    "standardDeviation": {
        "total": "5819",
        "ok": "4652",
        "ko": "6009"
    },
    "percentiles1": {
        "total": "11347",
        "ok": "12116",
        "ko": "10981"
    },
    "percentiles2": {
        "total": "14548",
        "ok": "14713",
        "ko": "14535"
    },
    "percentiles3": {
        "total": "17712",
        "ok": "18509",
        "ko": "17488"
    },
    "percentiles4": {
        "total": "18721",
        "ok": "19084",
        "ko": "18449"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 27,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 20,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 4175,
        "percentage": 21
    },
    "group4": {
        "name": "failed",
        "count": 15778,
        "percentage": 79
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "666.667",
        "ok": "140.733",
        "ko": "525.933"
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
