/*
Template Name: Admin Pro Admin
Author: Wrappixel
Email: niravjoshi87@gmail.com
File: js
*/
$(function() {
    "use strict";
    var dtosString = document.getElementById("dtos").value;
    dtosString = dtosString.replace(/payListRequestDTO.MngMonthDTO/g, '');
    dtosString = dtosString.replace(/\(/g, '\{');
    dtosString = dtosString.replace(/\)/g, '\}');
    // dtosString = dtosString.replace(/type=(\w+)/g, '"type":"$1"');
    dtosString = dtosString.replace(/month=(\w+)/g, '"date":"$1"');
    dtosString = dtosString.replace(/totalSales=/g, '"price":');
    dtosString = dtosString.replace(/count=/g, '"count":');
    console.log(dtosString);
    var dtos = JSON.parse(dtosString);
    console.log(dtos);
    var labels = dtos.map(function(item) {
        return item.date;
    });
    var seriesPrice = dtos.map(function(item) {
        return item.price;
    });
    var seriesCount = dtos.map(function(item) {
        return item.count;
    });
    console.log(labels);
    console.log(seriesPrice);
    console.log(seriesCount);
    // ==============================================================
    // sales ratio
    // ============================================================== 
    var chart = new Chartist.Line('.sales', {
        labels: labels,
        series: [seriesPrice]
        // seriesCount
    }, {
        low: 0,
        //가격조정 100  = 10만원까지 1000 = 100만원까지
        high: 5000000,
        showArea: true,
        fullWidth: true,
        plugins: [
            Chartist.plugins.tooltip()
        ],
        seriesBarDistance: 10,
        axisY: {
            onlyInteger: true,
            scaleMinSpace: 40,
            offset: 80,
            labelInterpolationFnc: function(value) {

                return value+ '원';
            }

        },

    });

    var chart = [chart];

    // ============================================================== 
    // Our Visitor
    // ============================================================== 

});