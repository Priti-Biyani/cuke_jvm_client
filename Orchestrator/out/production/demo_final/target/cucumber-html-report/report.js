$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("\u0027test/order.feature\u0027");
formatter.feature({
  "id": "place-order-online",
  "description": "",
  "name": "Place Order Online",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "place-order-online;place-order",
  "description": "",
  "name": "place order",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I visit the order merchant site and I place the order",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I change the status from play",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "order status is changed at merchant site",
  "keyword": "Then ",
  "line": 6
});
formatter.match({
  "location": "orderStepDefn.I_visit_the_order_merchant_site_and_I_place_the_order()"
});
formatter.result({
  "duration": 132592000,
  "status": "passed"
});
formatter.match({
  "location": "orderStepDefn.I_change_the_status_from_play()"
});
formatter.result({
  "duration": 12000,
  "status": "passed"
});
formatter.match({
  "location": "orderStepDefn.order_status_is_changed_at_merchant_site()"
});
formatter.result({
  "duration": 10000,
  "status": "passed"
});
});