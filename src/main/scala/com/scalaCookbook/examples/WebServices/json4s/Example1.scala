package com.scalaCookbook.examples.WebServices.json4s


import org.json4s._
import org.json4s.jackson.JsonMethods._

case class Address(street : String, city : String)
case class PersonAddress(name : String, address : Address)

object Example1 extends App {

  val testJson =
    """
{ "name": "joe",
  "address": {
    "street": "Bulevard",
    "city": "Helsinki"
  },
  "children": [
    {
      "name": "Mary",
      "age": 5,
      "birthdate": "2004-09-04T18:06:22Z"
    },
    {
      "name": "Mazy",
      "age": 3
    }
  ]
}
"""

  val output = parse(testJson)
  val name = output \ "name"
  val address = output \ "address"

  println(name)
  println(address)

  implicit val formats = DefaultFormats

  val converted = output.extract[PersonAddress]

  println(converted.name)
  println(converted.address.street + converted.address.city)


  val testJson1 =
    """
{ "user": "joe",
  "address": {
    "street": "Bulevard",
    "city": "Helsinki",
    "country": {
    "code": "CD" }
  },
  "children": [
    {
      "name": "Mary",
      "age": 5,
      "birthdate": "2004-09-04T18:06:22Z"
    },
    {
      "name": "Mazy",
      "age": 3
    }
  ]
}
"""


  case class Country(code : String)
  case class Address1(street : String, city : String, country : Country)
  //case class PersonAddress1(user : String, address : Address1)

  case class PersonAddress1(user : String)

  val output1 = parse(testJson1)

  val convertedOutput = output1.extract[PersonAddress1]

  println(convertedOutput.user)


  case class EventId(eventId : String)
  case class Metadata(metaData : EventId)

  val string =
    """{
    "metaData": {
      "eventId": "b45aa150-8929-4e70-b49b-dc12a7b822a8",
      "hostName": "staging-lpa-01",
      "instanceName": "staging-lpa-01",
      "requestHeaders": {
      "tls-version": "tls1.2",
      "cookie": "SSLB=1; akacd_pr_5=1525251171~rv; guid=8fdbcc01-aa78-45f9-9643-7ab687cd6e6e; mvthistory=eJyr8XD2940PDQYADEsCqw%3D%3D; user=QSplbl9VU3xIQ09NX1VT;",
      "x-forwarded-proto": "https",
      "true-client-ip": "91.232.36.4",
      "x-akamai-request-id": "d779c52.24458b7",
      "client-ip": "209.170.78.134",
      "akamai-origin-hop": "2",
      "pragma": "no-cache",
      "accept": "*/*",
      "via": "1.1 v1-akamaitech.net(ghost) (AkamaiGHost), 1.1 akamai.net(ghost) (AkamaiGHost), 1.1 ssl.staging1-hotels.com, 1.1 styx",
      "x-akamai-pr": "akacd_pr_5_rv=54",
      "x-hcom-request-id": "e6b2d4a0-37e8-11e8-9082-0242ac11003d",
      "x-akamai-config-log-detail": "true",
      "x-forwarded-server": "ssl.staging1-hotels.com, ssl.staging1-hotels.com",
      "x-forwarded-host": "www.staging1-hotels.com, www.staging1-hotels.com",
      "x-hcom-dio-styx-supported": "1",
      "host": "www.staging1-hotels.com",
      "x-edgeconnect-session-id": "922e3f17-5ac497ff-24458b7",
      "standard_timezone": "GMT",
      "cache-control": "no-cache, max-age=0",
      "sitespect": "1-1097",
      "accept-encoding": "gzip",
      "user-agent": "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)"
    },
      "sequenceTag": null,
      "sourceURI": "/landing/city.default.html",
      "timestamp": 1522833408274
    }
  }"""

  val cds1 = parse(string)

  println(cds1)

  val cds_output1 = cds1.extract[Metadata]

  println(cds_output1.metaData.eventId)

  val string1 =
    """ {
      "eventId": "b45aa150-8929-4e70-b49b-dc12a7b822a8",
      "hostName": "staging-lpa-01",
      "instanceName": "staging-lpa-01",
      "requestHeaders": {
      "tls-version": "tls1.2",
      "cookie": "SSLB=1; akacd_pr_5=1525251171~rv; guid=8fdbcc01-aa78-45f9-9643-7ab687cd6e6e; mvthistory=eJyr8XD2940PDQYADEsCqw%3D%3D; user=QSplbl9VU3xIQ09NX1VT;",
      "x-forwarded-proto": "https",
      "true-client-ip": "91.232.36.4",
      "x-akamai-request-id": "d779c52.24458b7",
      "client-ip": "209.170.78.134",
      "akamai-origin-hop": "2",
      "pragma": "no-cache",
      "accept": "*/*",
      "via": "1.1 v1-akamaitech.net(ghost) (AkamaiGHost), 1.1 akamai.net(ghost) (AkamaiGHost), 1.1 ssl.staging1-hotels.com, 1.1 styx",
      "x-akamai-pr": "akacd_pr_5_rv=54",
      "x-hcom-request-id": "e6b2d4a0-37e8-11e8-9082-0242ac11003d",
      "x-akamai-config-log-detail": "true",
      "x-forwarded-server": "ssl.staging1-hotels.com, ssl.staging1-hotels.com",
      "x-forwarded-host": "www.staging1-hotels.com, www.staging1-hotels.com",
      "x-hcom-dio-styx-supported": "1",
      "host": "www.staging1-hotels.com",
      "x-edgeconnect-session-id": "922e3f17-5ac497ff-24458b7",
      "standard_timezone": "GMT",
      "cache-control": "no-cache, max-age=0",
      "sitespect": "1-1097",
      "accept-encoding": "gzip",
      "user-agent": "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)"
    },
      "sequenceTag": null,
      "sourceURI": "/landing/city.default.html",
      "timestamp": 1522833408274
    }"""

  val cds = parse(string1)

  val cds_output = cds.extract[EventId]

  println(cds_output.eventId)


  val wholeMessage = """{
                       |	"metaData": {
                       |		"eventId": "b45aa150-8929-4e70-b49b-dc12a7b822a8",
                       |		"hostName": "staging-lpa-01",
                       |		"instanceName": "staging-lpa-01",
                       |		"requestHeaders": {
                       |			"tls-version": "tls1.2",
                       |			"cookie": "SSLB=1; akacd_pr_5=1525251171~rv; guid=8fdbcc01-aa78-45f9-9643-7ab687cd6e6e; mvthistory=eJyr8XD2940PDQYADEsCqw%3D%3D; user=QSplbl9VU3xIQ09NX1VT;",
                       |			"x-forwarded-proto": "https",
                       |			"true-client-ip": "91.232.36.4",
                       |			"x-akamai-request-id": "d779c52.24458b7",
                       |			"client-ip": "209.170.78.134",
                       |			"akamai-origin-hop": "2",
                       |			"pragma": "no-cache",
                       |			"accept": "*/*",
                       |			"via": "1.1 v1-akamaitech.net(ghost) (AkamaiGHost), 1.1 akamai.net(ghost) (AkamaiGHost), 1.1 ssl.staging1-hotels.com, 1.1 styx",
                       |			"x-akamai-pr": "akacd_pr_5_rv=54",
                       |			"x-hcom-request-id": "e6b2d4a0-37e8-11e8-9082-0242ac11003d",
                       |			"x-akamai-config-log-detail": "true",
                       |			"x-forwarded-server": "ssl.staging1-hotels.com, ssl.staging1-hotels.com",
                       |			"x-forwarded-host": "www.staging1-hotels.com, www.staging1-hotels.com",
                       |			"x-hcom-dio-styx-supported": "1",
                       |			"host": "www.staging1-hotels.com",
                       |			"x-edgeconnect-session-id": "922e3f17-5ac497ff-24458b7",
                       |			"standard_timezone": "GMT",
                       |			"cache-control": "no-cache, max-age=0",
                       |			"sitespect": "1-1097",
                       |			"accept-encoding": "gzip",
                       |			"user-agent": "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)"
                       |		},
                       |		"sequenceTag": null,
                       |		"sourceURI": "/landing/city.default.html",
                       |		"timestamp": 1522833408274
                       |	},
                       |	"udt": {
                       |		"booking": {
                       |			"additionalFees": null,
                       |			"allPriceComponents": null,
                       |			"avgNightlyRate": null,
                       |			"avgNightlyRateFloodlightCurrency": null,
                       |			"avgNightlyRatePOSDefaultCurrency": null,
                       |			"avgNightlyRateTransactionCurrency": null,
                       |			"avgNightlyRateUSD": null,
                       |			"billedCurrency": null,
                       |			"bookingChange": null,
                       |			"bookingError": {
                       |				"bookingErrorCode": null,
                       |				"couponDiscountApplyError": null,
                       |				"hotelNotAvailableError": null,
                       |				"incompleteRoomAvailibilityError": null,
                       |				"inventoryNotAvailableError": null,
                       |				"inventoryPaymentError": null,
                       |				"paymentAuthenticationErrorData": null,
                       |				"paymentError": null,
                       |				"paymentOptionException": null,
                       |				"redirectedPaymentError": null
                       |			},
                       |			"bookingStatus": null,
                       |			"checkinDate": null,
                       |			"checkoutDate": null,
                       |			"confirmationNumbers": null,
                       |			"couponCode": null,
                       |			"couponValue": null,
                       |			"currencyRates": null,
                       |			"custPrefCurrency": null,
                       |			"customerConfirmationNumber": null,
                       |			"destinationId": null,
                       |			"displayCurrency": null,
                       |			"dynamicRateRule": null,
                       |			"freqFlyerNo": null,
                       |			"giftCardNumber": null,
                       |			"hermesBookingIdentifiers": null,
                       |			"installment": null,
                       |			"itineraryId": null,
                       |			"lpas": false,
                       |			"omniturePurchaseID": null,
                       |			"omnitureV15": null,
                       |			"orderNumber": null,
                       |			"partnerCode": null,
                       |			"payment3rdParty": null,
                       |			"paymentModel": null,
                       |			"paymentType": null,
                       |			"posDefaultCurrency": null,
                       |			"priceChange": null,
                       |			"rateRuleDescription": null,
                       |			"rateRuleDescriptionId": null,
                       |			"rooms": null,
                       |			"selectedRoomTypeRankVariance": null,
                       |			"shpm": null,
                       |			"soldOut": null,
                       |			"supplierOrderNumber": null,
                       |			"taxesAndFees": null,
                       |			"taxesAndFeesTransactionCurrency": null,
                       |			"transactionCurrency": null,
                       |			"valueBeforeDiscountPOSDefaultCurrency": null,
                       |			"valueBeforeDiscountTransactionCurrency": null,
                       |			"valueBeforeDiscountUSD": null,
                       |			"valuePaidBeforeTaxesAndFeesBilledCurrency": null,
                       |			"valuePaidBeforeTaxesAndFeesDisplayCurrency": null,
                       |			"valuePaidBeforeTaxesAndFeesUSD": null,
                       |			"valuePaidBeforeTaxesPOSaCurrency": null,
                       |			"valuePaidBeforeTaxesTransactionCurrency": null,
                       |			"valuePaidFloodlightCurrency": null,
                       |			"valuePaidPOSDefaultCurrency": null,
                       |			"valuePaidTransactionCurrency": null,
                       |			"valuePaidUSD": null,
                       |			"valuePaidUSDBeforeTaxes": null,
                       |			"wrBurned": null,
                       |			"wrEarned": null
                       |		},
                       |		"event": {
                       |			"bot": true,
                       |			"discardForSearchProcessing": null,
                       |			"eventType": "la"
                       |		},
                       |		"marketing": {
                       |			"affiliatePartnerId": null,
                       |			"currentRestricted": {
                       |				"fullMarketingCode": "Brand",
                       |				"marketingCode": "Brand"
                       |			},
                       |			"currentUnrestricted": {
                       |				"fullMarketingCode": "Brand",
                       |				"marketingCode": "Brand"
                       |			},
                       |			"externalHttpReferer": null,
                       |			"fullMarketingTrackingCode": null,
                       |			"h4p": null,
                       |			"kwrd": null,
                       |			"lastTouched7DayMarketingCode": null,
                       |			"lastTouchedMarketingCode": null,
                       |			"marketingChannel": null,
                       |			"marketingChannelTypeCode": null,
                       |			"marketingPartner": null,
                       |			"marketingPlacement": null,
                       |			"marketingSegment": null,
                       |			"nativeCurrentProvisional": null,
                       |			"nativeCurrentRestricted": null,
                       |			"nativeCurrentUnrestricted": null,
                       |			"partnerCode": null,
                       |			"restrictedLastTouch": {
                       |				"fullMarketingCode": "Brand",
                       |				"marketingCode": "Brand"
                       |			},
                       |			"tduid": null,
                       |			"visitMarketingCode": null,
                       |			"wapax": null,
                       |			"wapbx": null
                       |		},
                       |		"mvtHistory": {
                       |			"athenaMvts": "41.0,376.0,555.0,785.0,904.0,1111.2,1167.0,1291.0,1292.0,1293.0,1294.0,2387.0,2638.0,2791.0,2792.0,2977.0,3034.0,3044.0,3045.0,3423.0,3620.0,3881.0,3998.0,4024.0,4200.0,4229.0,4258.0,4440.0,4456.0,4577.0,4580.99,4592.0,4595.0,4602.0,4618.0,4647.0,4677.0,4678.0,4714.0,4716.0,4725.0,4786.0,4793.0,4794.0,4824.0,4827.0,4828.0,4841.0,4860.0,4869.0,4904.0,4919.0,4927.0,4935.0,4937.0,4948.0,4952.0,4953.0,4956.0,4959.1,4961.0,4964.0,4967.0,4969.0,4976.0,4977.0,4992.0,5000.0,5001.0,5003.0,5004.0,5031.0,5036.0,5037.0,5045.0,5056.0,5060.0,5061.0,5062.0,5067.0,5073.0,5088.0,5094.1,5104.0,5141.0,5161.0,5167.0,5184.0,5215.0,5222.0,5227.0,5234.0,5236.0,5246.0,5252.0,5254.0,5274.0,5277.0,5278.0,5281.0,5302.0,5304.0,5306.0,5311.0,5333.0,5339.0,5342.0,5345.0,5349.0,5355.0,5358.0,5370.0,5571.0,5597.0,5632.0,5649.0,5650.0,5651.0,5655.0,5656.0,5658.0,5663.0,5664.0,5672.0,5678.0,5687.0,5689.0,5694.0,5695.0,5742.0,5745.0,5754.0,5755.0,5756.0,5757.0,5758.0,5759.0,5760.0,5761.0,5762.0,5775.0,5786.0,5810.0,5812.0,5826.0,5837.0,5841.0,5843.0,5845.0,5856.0,5897.0,5898.0,5910.0,5924.0,5937.0,5940.0,5953.0,5957.0,5971.0,5979.0,5996.0,5998.0,6009.0,6032.0,6033.0,6035.0,6039.0,6041.0,6043.0,6045.0,6046.0,6052.1,6073.0,6074.0,6078.0,6093.0,6097.0,6099.0,6108.0,6111.0,6113.0,6117.0,6129.0,6141.0,6156.0,6171.0,6172.0,6184.0,6197.0,6200.0,6202.0,6205.0,6208.0,6230.0,6232.0,6236.0,6239.0,6240.0,6241.0,6242.0,6243.0,6244.0,6245.0,6246.0,6249.0,6253.0,6255.0,6256.0,6260.0,6261.0,6262.0,6267.0,6268.0,6269.0,6271.0,6299.0,6306.0,6320.0,6322.0,6331.0,6333.0,6357.0,6369.0,6370.0,6372.0,6378.0,6383.0,6388.0,6394.0,6403.0,6410.0,6411.0,6413.0,6415.0,6425.0,6427.0,6435.0,6438.0,6439.0,6440.0,6442.0,6447.0,6450.0,6451.0,6455.0,6476.0,6477.0,6489.0,6494.0,6495.0,6496.0,6497.0,6498.0,6499.0,6501.0,6502.0,6509.0,6512.0,6513.0,6538.0,6540.0,6544.0,6545.0,6549.0,6550.0,6553.0,6555.0,6558.0,6577.0,6582.0,6583.0,6584.0,6585.0,6590.0,6614.0,6621.0,6622.0,6623.0,6624.0,6626.0,6627.0,6629.0,6630.0,6631.0,6632.0,6634.0,6637.0,6642.0,6659.0,6660.0,6661.0,6662.0,6663.0,6665.0,6667.0,6690.0,6710.1,6721.0,6725.0,6726.0,6727.0,6728.0,6742.0,6743.0,6751.0,6754.0,6755.0,6761.0,6762.0,6775.0,6776.0,6777.0,6778.0,6779.0,6780.0,6782.0,6783.0,6786.0,6787.0,6789.0,6796.0,6797.0,6799.0,6807.0,6812.0,6854.0,6855.0,6857.0,6858.0,6859.0,6861.0,6866.0,6867.0,6870.0,6874.0,6907.0,6909.0,6911.0,6913.0,6925.0,6927.0,6932.0,6933.0,6938.0,6939.0,6940.0,6941.0,6942.0,6944.0,6946.0,6947.0,6956.0,6959.0,6966.0,6991.0,7000.0,7004.0,7022.0,7025.0,7026.0,7031.0,7034.0,7035.0,7036.0,7039.0,7044.0,7060.0,7061.0,7062.0,7064.0,7066.0,7067.0,7069.0,7073.0,7074.0,7075.0,7076.0,7077.0,7078.0,7079.0,7080.0,7081.0,7082.0,7083.0,7084.0,7085.0,7086.0,7087.0,7088.0,7089.0,7090.0,7091.0,7093.0,7094.0,7097.0,7098.0,7099.0,7100.0,7102.0,7103.0,7105.0,7108.0,7115.0,7116.0,7117.0,7120.0,7121.0,7122.0,7123.0,7124.0,7126.0,7127.0,7130.0,7132.0,7133.0,7145.0,7146.0,7148.0,7149.0,7152.0,7157.0,7163.0,7177.0,7200.0,7209.0,7777.0,7999.0,66666.0,66668.0,66669.0,67890.0,98761.0,222222.0,444444.0,777778.0,987654.0",
                       |			"mvts": "41.0.0:376.0.0:555.0.0:785.0.0:904.0.0:1111.2.0:1167.0.0:1291.0.0:1292.0.0:1293.0.0:1294.0.0:2387.0.0:2638.0.0:2791.0.0:2792.0.0:2977.0.0:3034.0.0:3044.0.0:3045.0.0:3423.0.0:3620.0.0:3881.0.0:3998.0.0:4024.0.0:4200.0.0:4229.0.0:4258.0.0:4440.0.0:4456.0.0:4577.0.0:4580.99.0:4592.0.0:4595.0.0:4602.0.0:4618.0.0:4647.0.0:4677.0.0:4678.0.0:4714.0.0:4716.0.0:4725.0.0:4786.0.0:4793.0.0:4794.0.0:4824.0.0:4827.0.0:4828.0.0:4841.0.0:4860.0.0:4869.0.0:4904.0.0:4919.0.0:4927.0.0:4935.0.0:4937.0.0:4948.0.0:4952.0.0:4953.0.0:4956.0.0:4959.1.0:4961.0.0:4964.0.0:4967.0.0:4969.0.0:4976.0.0:4977.0.0:4992.0.0:5000.0.0:5001.0.0:5003.0.0:5004.0.0:5031.0.0:5036.0.0:5037.0.0:5045.0.0:5056.0.0:5060.0.0:5061.0.0:5062.0.0:5067.0.0:5073.0.0:5088.0.0:5094.1.0:5104.0.0:5141.0.0:5161.0.0:5167.0.0:5184.0.0:5215.0.0:5222.0.0:5227.0.0:5234.0.0:5236.0.0:5246.0.0:5252.0.0:5254.0.0:5274.0.0:5277.0.0:5278.0.0:5281.0.0:5302.0.0:5304.0.0:5306.0.0:5311.0.0:5333.0.0:5339.0.0:5342.0.0:5345.0.0:5349.0.0:5355.0.0:5358.0.0:5370.0.0:5571.0.0:5597.0.0:5632.0.0:5649.0.0:5650.0.0:5651.0.0:5655.0.0:5656.0.0:5658.0.0:5663.0.0:5664.0.0:5672.0.0:5678.0.0:5687.0.0:5689.0.0:5694.0.0:5695.0.0:5742.0.0:5745.0.0:5754.0.0:5755.0.0:5756.0.0:5757.0.0:5758.0.0:5759.0.0:5760.0.0:5761.0.0:5762.0.0:5775.0.0:5786.0.0:5810.0.0:5812.0.0:5826.0.0:5837.0.0:5841.0.0:5843.0.0:5845.0.0:5856.0.0:5897.0.0:5898.0.0:5910.0.0:5924.0.0:5937.0.0:5940.0.0:5953.0.0:5957.0.0:5971.0.0:5979.0.0:5996.0.0:5998.0.0:6009.0.0:6032.0.0:6033.0.0:6035.0.0:6039.0.0:6041.0.0:6043.0.0:6045.0.0:6046.0.0:6052.1.0:6073.0.0:6074.0.0:6078.0.0:6093.0.0:6097.0.0:6099.0.0:6108.0.0:6111.0.0:6113.0.0:6117.0.0:6129.0.0:6141.0.0:6156.0.0:6171.0.0:6172.0.0:6184.0.0:6197.0.0:6200.0.0:6202.0.0:6205.0.0:6208.0.0:6230.0.0:6232.0.0:6236.0.0:6239.0.0:6240.0.0:6241.0.0:6242.0.0:6243.0.0:6244.0.0:6245.0.0:6246.0.0:6249.0.0:6253.0.0:6255.0.0:6256.0.0:6260.0.0:6261.0.0:6262.0.0:6267.0.0:6268.0.0:6269.0.0:6271.0.0:6299.0.0:6306.0.0:6320.0.0:6322.0.0:6331.0.0:6333.0.0:6357.0.0:6369.0.0:6370.0.0:6372.0.0:6378.0.0:6383.0.0:6388.0.0:6394.0.0:6403.0.0:6410.0.0:6411.0.0:6413.0.0:6415.0.0:6425.0.0:6427.0.0:6435.0.0:6438.0.0:6439.0.0:6440.0.0:6442.0.0:6447.0.0:6450.0.0:6451.0.0:6455.0.0:6476.0.0:6477.0.0:6489.0.0:6494.0.0:6495.0.0:6496.0.0:6497.0.0:6498.0.0:6499.0.0:6501.0.0:6502.0.0:6509.0.0:6512.0.0:6513.0.0:6538.0.0:6540.0.0:6544.0.0:6545.0.0:6549.0.0:6550.0.0:6553.0.0:6555.0.0:6558.0.0:6577.0.0:6582.0.0:6583.0.0:6584.0.0:6585.0.0:6590.0.0:6614.0.0:6621.0.0:6622.0.0:6623.0.0:6624.0.0:6626.0.0:6627.0.0:6629.0.0:6630.0.0:6631.0.0:6632.0.0:6634.0.0:6637.0.0:6642.0.0:6659.0.0:6660.0.0:6661.0.0:6662.0.0:6663.0.0:6665.0.0:6667.0.0:6690.0.0:6710.1.0:6721.0.0:6725.0.0:6726.0.0:6727.0.0:6728.0.0:6742.0.0:6743.0.0:6751.0.0:6754.0.0:6755.0.0:6761.0.0:6762.0.0:6775.0.0:6776.0.0:6777.0.0:6778.0.0:6779.0.0:6780.0.0:6782.0.0:6783.0.0:6786.0.0:6787.0.0:6789.0.0:6796.0.0:6797.0.0:6799.0.0:6807.0.0:6812.0.0:6854.0.0:6855.0.0:6857.0.0:6858.0.0:6859.0.0:6861.0.0:6866.0.0:6867.0.0:6870.0.0:6874.0.0:6907.0.0:6909.0.0:6911.0.0:6913.0.0:6925.0.0:6927.0.0:6932.0.0:6933.0.0:6938.0.0:6939.0.0:6940.0.0:6941.0.0:6942.0.0:6944.0.0:6946.0.0:6947.0.0:6956.0.0:6959.0.0:6966.0.0:6991.0.0:7000.0.0:7004.0.0:7022.0.0:7025.0.0:7026.0.0:7031.0.0:7034.0.0:7035.0.0:7036.0.0:7039.0.0:7044.0.0:7060.0.0:7061.0.0:7062.0.0:7064.0.0:7066.0.0:7067.0.0:7069.0.0:7073.0.0:7074.0.0:7075.0.0:7076.0.0:7077.0.0:7078.0.0:7079.0.0:7080.0.0:7081.0.0:7082.0.0:7083.0.0:7084.0.0:7085.0.0:7086.0.0:7087.0.0:7088.0.0:7089.0.0:7090.0.0:7091.0.0:7093.0.0:7094.0.0:7097.0.0:7098.0.0:7099.0.0:7100.0.0:7102.0.0:7103.0.0:7105.0.0:7108.0.0:7115.0.0:7116.0.0:7117.0.0:7120.0.0:7121.0.0:7122.0.0:7123.0.0:7124.0.0:7126.0.0:7127.0.0:7130.0.0:7132.0.0:7133.0.0:7145.0.0:7146.0.0:7148.0.0:7149.0.0:7152.0.0:7157.0.0:7163.0.0:7177.0.0:7200.0.0:7209.0.0:7777.0.0:7999.0.0:66666.0.0:66668.0.0:66669.0.0:67890.0.0:98761.0.0:222222.0.0:444444.0.0:777778.0.0:987654.0.0|HCOM_US"
                       |		},
                       |		"page": {
                       |			"additionalPageInformation1": null,
                       |			"additionalPageInformation2": "city landing;boilerplate",
                       |			"currency": "USD",
                       |			"dataCentre": "chx",
                       |			"fullURL": "https://www.staging1-hotels.com/de1642799/",
                       |			"internalRfrrId": null,
                       |			"landingPageAttributes": "Country=Colorado City=Frisco",
                       |			"packageRateDisplayed": null,
                       |			"pageName": "city landing",
                       |			"random10Alpha": "hy5ckacdoe",
                       |			"random10Numeric": "7445753168",
                       |			"requestId": "e6b2d4a0-37e8-11e8-9082-0242ac11003d",
                       |			"siteSection": "city landing"
                       |		},
                       |		"property": {
                       |			"accommodationTypeIds": null,
                       |			"averageNightlyPriceInUSD": null,
                       |			"averageNightlyPriceTax": null,
                       |			"cheapestAfr": null,
                       |			"city": null,
                       |			"cityId": null,
                       |			"country": null,
                       |			"countryId": null,
                       |			"couponElligible": null,
                       |			"dealId": null,
                       |			"destinationId": null,
                       |			"featuredPrice": null,
                       |			"featuredPriceBasis": null,
                       |			"featuredPriceMessage": null,
                       |			"hotelBrandId": null,
                       |			"hotelContractType": null,
                       |			"hotelId": null,
                       |			"hotelInventoryType": null,
                       |			"hotelName": null,
                       |			"hotelNameLocalized": null,
                       |			"hotelSupplierId": null,
                       |			"metadata": null,
                       |			"numLocalReviews": null,
                       |			"numNonLocalizedReviews": null,
                       |			"numTotalReviews": null,
                       |			"numTotalReviewsRangeMax": null,
                       |			"numTotalReviewsRangeMin": null,
                       |			"numTranslatedReviews": null,
                       |			"priceDisplay": null,
                       |			"priceDisplayTaxInclusive": null,
                       |			"propertyImageOrder": null,
                       |			"qualityScore": null,
                       |			"reviewScore": null,
                       |			"rooms": null,
                       |			"starRating": null,
                       |			"state": null,
                       |			"stateId": null,
                       |			"strikethroughPrice": null,
                       |			"superRegion": null,
                       |			"superRegionId": null,
                       |			"supplierHotelId": null,
                       |			"totalAfr": null,
                       |			"unavail": null,
                       |			"wrElligible": null
                       |		},
                       |		"search": {
                       |			"accessibility": null,
                       |			"accommodationTypeIds": null,
                       |			"amenityIds": null,
                       |			"checkinDate": null,
                       |			"checkoutDate": null,
                       |			"customerMessaging": null,
                       |			"destinationId": "1642799",
                       |			"distanceSortLandmarkId": null,
                       |			"domestic": null,
                       |			"exclusive": null,
                       |			"giftCardFilterOptions": null,
                       |			"guestRatingMax": null,
                       |			"guestRatingMin": null,
                       |			"hotelCity": null,
                       |			"hotelCountry": null,
                       |			"hotelName": null,
                       |			"hotelState": null,
                       |			"hotels": null,
                       |			"hrwFilterOptions": null,
                       |			"intentmediaRequested": null,
                       |			"landmarkIds": null,
                       |			"latitude": null,
                       |			"longitude": null,
                       |			"luckyStrikePriceSelectionEnabled": null,
                       |			"map": null,
                       |			"mapLatLong": null,
                       |			"mapView": null,
                       |			"merchAlias": null,
                       |			"neighborhoodIds": null,
                       |			"numAdultsTotal": null,
                       |			"numChildrenTotal": null,
                       |			"numNights": null,
                       |			"numRooms": null,
                       |			"partnerRedemption": null,
                       |			"priceRangeCurrency": null,
                       |			"priceRangeMax": null,
                       |			"priceRangeMin": null,
                       |			"resolvedDestinationId": null,
                       |			"rooms": null,
                       |			"searchId": null,
                       |			"searchResultsPageStatistics": null,
                       |			"searchWindow": null,
                       |			"seoDestId": null,
                       |			"sortOrder": null,
                       |			"sponsoredListings": null,
                       |			"starRating": null,
                       |			"starRatingMax": null,
                       |			"starRatingMin": null,
                       |			"supplierCollectedChargesApplicable": null,
                       |			"themeIds": null,
                       |			"total": null,
                       |			"tripType": null,
                       |			"zoomLevel": null
                       |		},
                       |		"user": {
                       |			"accountEvent": null,
                       |			"assignedMvts": null,
                       |			"clientId": "251463",
                       |			"dossierId": null,
                       |			"email": null,
                       |			"exactTargetDeviceId": null,
                       |			"existingCustomer": 0,
                       |			"fcStatus": "notApplicable",
                       |			"geolocation": {
                       |				"latitude": "",
                       |				"longitude": ""
                       |			},
                       |			"guid": "8fdbcc01-aa78-45f9-9643-7ab687cd6e6e",
                       |			"hrwMemberStatus": "notApplicable",
                       |			"hrwTier": "notApplicable",
                       |			"ipAddress": "91.232.36.4",
                       |			"locale": "en_US",
                       |			"loyalty": {
                       |				"accountNightsBalance": null,
                       |				"currency": null,
                       |				"freeNightLockedCurrency": null,
                       |				"freeNightUSD": null,
                       |				"freeNightsAvailable": null,
                       |				"nightsToFreeNight": null,
                       |				"totalNightsLifetimeEarned": null,
                       |				"totalNightsLifetimeRedeemed": null
                       |			},
                       |			"loyaltyAccountId": null,
                       |			"md5email": null,
                       |			"mobileAdvertisingId": null,
                       |			"mobileDeviceId": null,
                       |			"mobileDeviceType": null,
                       |			"newsletterEmail": null,
                       |			"newsletterEvent": null,
                       |			"newsletterOptInStatus": "unknown",
                       |			"platformId": "Desktop",
                       |			"pos": "HCOM_US",
                       |			"reviewEvent": null,
                       |			"segments": {
                       |				"appBooker": null,
                       |				"averageBookingValueUsd": null,
                       |				"currentSegment": "u",
                       |				"currentShopperIntent": null,
                       |				"directSegment": "0",
                       |				"kevin": null,
                       |				"lifetimeValueGross3yearUsd": null,
                       |				"mobileAppUser": null,
                       |				"orderCountByPlatforms": {},
                       |				"previousIntent": "0",
                       |				"reviewCount": null,
                       |				"ultraHighValue": null,
                       |				"visitCount3Month": 0,
                       |				"visitCountByPlatforms": {}
                       |			},
                       |			"sessionId": "Z4jd9vkwh5d",
                       |			"signInMethod": "notApplicable",
                       |			"signInState": "anonymous",
                       |			"visitorId": null,
                       |			"visitorState": "returnVisitor",
                       |			"wrStatus": "Returning Visitor"
                       |		}
                       |	}
                       |}""".stripMargin


  val cdsMessage = parse(wholeMessage)

  val cds_output_eventId = cdsMessage.extract[Metadata]

  println(cds_output_eventId.metaData.eventId)


  //

  println("Extracting eventId from metadata .... ")
  val cdsMessageMetadata = parse(wholeMessage) \ "metaData"

  println(cdsMessageMetadata)

  val cds_output_eventId_metadata = cdsMessageMetadata.extract[EventId]

  println(cds_output_eventId_metadata)

  case class HostName(hostName : String)

  println(cdsMessageMetadata.extract[HostName])


  case class UDT(udt : User)
  case class User(user : Data)
  case class Data(guid : Option[String],
                  sessionid : Option[String],
                  platformid : Option[String],
                  visitorId : Option[String],
                  clientId : Option[String],
                  dossierId : Option[String],
                  email : Option[String]
                 )


  val cds_output_eventId1 = cdsMessage.extract[UDT]

  println(cds_output_eventId1.udt.user.guid + " -- "
    + cds_output_eventId1.udt.user.sessionid + " -- "
    + cds_output_eventId1.udt.user.platformid + " -- "
    + cds_output_eventId1.udt.user.visitorId + " -- "
    + cds_output_eventId1.udt.user.clientId + " -- "
    + cds_output_eventId1.udt.user.dossierId + " -- "
    + cds_output_eventId1.udt.user.email + " -- "
  )


  val testJson2 =
    """
{ "user": "joe",
  "address": {
    "street": "Bulevard",
    "city": "Helsinki",
    "country": {
    "code": "CD" }
  },
  "children": [
    {
      "name": "Mary",
      "age": 5,
      "birthdate": "2004-09-04T18:06:22Z"
    },
    {
      "name": "Mazy",
      "age": 3
    }
  ]
}
"""


  case class Country1(code : String)
  case class Address2(street : String, city : String, country : Country)
  //case class PersonAddress1(user : String, address : Address1)

  case class PersonAddress2(user : String)

  case class SessionId (sessionId : String)

  val output2 = parse(testJson1)

  println(output2)

  val cdsMessageUser = parse(wholeMessage) \ "udt" \ "user"

  case class Guid(guid : String)

  println("Printing the whole of user ... ")
  println(cdsMessageUser)

  val cds_output_eventId2 = cdsMessageUser.extract[Guid]

  println("Printing two level outputs ... ")
  println(cds_output_eventId2.guid)


  val json = parse(wholeMessage).values

  println("********** printing the values")
  //println(json)

  val json1 = parse(wholeMessage).children

  println("********** printing the children")
  //println(json1)

  println("********** iterating through the lsit **********" )
  //json1.foreach(println)


  case class BookingStatus(bookingStatus : Option[String])
  val booking = parse(wholeMessage) \ "udt" \ "booking"

  val bookingStatus = booking.extract[BookingStatus]

  println(bookingStatus.bookingStatus.getOrElse("Null"))


  println(booking)

  val str = parse(wholeMessage).children

  println(parse(wholeMessage).asInstanceOf[JObject].values.head._1)
  println(parse(wholeMessage).asInstanceOf[JObject].values.head._2)


  val map = parse(wholeMessage).asInstanceOf[JObject].values.toList.filter(x => x == "udt")


  map.map{ case (x,y) => println(x) }


  case class RequestHeaders (referer : String)

  val requestHeaders1 = parse(wholeMessage) \ "metaData" \ "requestHeaders"
  println("Printing double quotes ")
  println(requestHeaders1)

  val requestHeaders = parse(wholeMessage) \\ "metaData" \\ "requestHeaders"

  println("Printing double quotes ")
  println(requestHeaders)
  val rh = requestHeaders.extract[RequestHeaders]

  println(rh.referer)

}
