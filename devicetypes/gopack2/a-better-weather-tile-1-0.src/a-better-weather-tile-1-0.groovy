/**
*  Copyright 2015 SmartThings
*
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*  SmartWeather Station
*
*  Author: SmartThings
*
*  Date: 2013-04-30
* 
* I adapted the smart weather station tile 2.o from TKSID.  Thanks for giving me a jumping off point.  This is my first attempt as to
* building a weather device handler.  
*
* What I had a need for was to be able to get weather for locations besides my Smartthings hub location.  So I adapted this "Better Weather Tile 1.0"
* It allows for 3 locations to be monitored and the ability to switch weather reporting by simply pressing the icon for each location.
* 
* The icons are hardcoded into the handler, if I ever figure out how let them be defined in the preferences section I will make that change.  But for 
* now it is hard coded.  The images are available on my GitHub repository.  If you want to change them they are in the tiles section.
* 
* This also works with webCore.  You can change locations from there (loc1, loc2, loc3) and access all the attributes from webCore as well.  I personally 
* am the kind of person that likes point and click vs remembering the syntax in webCore to get information.  This should make it easier for many starting out 
* building pistons.
* Good Luck and Hope You Find a Use for it and enjoy! 

*
*
* 3/15/2018 Initial Release
* 3/16/2018 updated preferences section to help with setting up with locations outside US
* 3/23/2018 Changed the way the temperature tile displays information and pulls location fr09m preferences defined by user
**/


metadata {
    definition (name: "A Better Weather Tile 1.0", namespace: "Gopack2", author: "Gopack2") {
        capability "Illuminance Measurement"
        capability "Temperature Measurement"
        capability "Relative Humidity Measurement"
        capability "Sensor"
        capability "Polling"
		
        attribute "almanacNormalTempHigh", "number"
        attribute "almanacNormalTempHighRecord", "string"
        attribute "almanacNormalTempHighRecordYear", "string"
        attribute "almanacNormalTempLow", "string"
        attribute "almanacNormalTempLowRecordYear", "string"
        attribute "almanacNormalTempLowRecord", "number"
        attribute "almanacAirportCode", "string"
       	attribute "alert", "string"
        attribute "alertKeys", "string"
        attribute "alertMessage","string"
  		attribute "city", "string"
       	attribute "country", "string"
        attribute "dewPoint","string"
     	attribute "elevation", "string"       
        attribute "feelsLike", "string"
       	attribute "ForecastFriday","string"
        attribute "forecastIcon", "string"
    	attribute "ForecastMonday", "string"
		attribute "ForecastSaturday","string"
  	 	attribute "ForecastSunday", "string"
       	attribute "ForecastThursday","string"
        attribute "ForecastTuesday","string"  
        attribute "ForecastWednesday","string"
        attribute "Forecast1Day","string"
        attribute "Forecast2Day","string"
        attribute "Forecast3Day","string"
        attribute "Forecast4Day","string"
        attribute "Forecast5Day","string"
        attribute "Forecast6Day","string"
        attribute "Forecast7Day","string"
		attribute "fullLocation", "string"
        attribute "heatIndex","string"
     	attribute "latitude", "string"
 		attribute "localSunrise", "string"
        attribute "localSunset", "string"
        attribute "localMoonrise", "string"
        attribute "localMoonset", "string"
     	attribute "longitude", "string"
		attribute "observationEpoch","string"
		attribute "observationTime","string"
		attribute "precipLastHour", "string"
		attribute "precipLastHourString","string"
		attribute "precipToday","string"
		attribute "precipTodayString","string"
   	 	attribute "pressure", "string" 
		attribute "pressureTrend", "string"
        attribute "solarradiation", "string"
     	attribute "state", "string"
        attribute "tempString","string"
       	attribute "timeZoneOffset", "string"
        attribute "uv_index", "string"
        attribute "visibility", "string"
        attribute "water", "string"
        attribute "weather", "string"
        attribute "weatherIcon", "string"
        attribute "wind", "string"
        attribute "wind_gust", "string"
        attribute "windChill","string"
        attribute "winddirection", "string"
		attribute "winddirection_deg", "string"
        attribute "windinfo", "string"
		attribute "windString", "string"
        attribute "yesterdayFog", "string"
		attribute "yesterdayRain", "string"
        attribute "yesterdaySnow", "string"
		attribute "yesterdaySnowFall", "string"
        attribute "yesterdaySnowFallMonthToDate","string"
        attribute "yesterdaySnowFallSinceJuly","string"
        attribute "yesterdayHail", "string"
		attribute "yesterdayThunder", "string"
        attribute "yesterdayTornado", "string"
		attribute "yesterdayAvgTemp", "string"
        attribute "yesterdayAvgDewpt", "string"
		attribute "yesterdayAvgPressure", "string"
        attribute "yesterdayAvgWinSspd", "string"
		attribute "yesterdayAvgWindDird", "string"
        attribute "yesterdayAvgVis", "string"
		attribute "yesterdayMaxHumidity", "string"
        attribute "yesterdayMinHumidity", "string"
        attribute "yesterdayMaxTemp", "string"
		attribute "yesterdayMinTemp", "string"
        attribute "yesterdayMaxDewPt", "string"
		attribute "yesterdayMinDewPt", "string"
        attribute "yesterdayMaxPressure", "string"
		attribute "yesterdayMinPressure", "string"
        attribute "yesterdayMaxWindSpd", "string"
		attribute "yesterdayMinWindSpd", "string"
        attribute "yesterdayMaxVis", "string"
		attribute "yesterdayMinVis", "string"
        attribute "yesterdayPrecip", "string"
		attribute "yesterdayHeatingDegreeDays", "string"
        attribute "yesterdayCoolingDegreeDays", "string"
        attribute "yesterdayMonthToDateCoolingDegreeDays", "string"
        attribute "Zip","string"
        
        command "loc1"
      	command "loc2"
      	command "loc3"
       	command "refresh"
        command "loc1ChangeDefaultZip"
        command "loc1RestoreDefaultZip"
    }
  	preferences {
    	input name: "location1Zip", type: "string", title: "Enter A Zip Code For Location 1. For the US you can use zipcode, State/City or Latitude/Longitude.  If using outside the US Try UK/city or Latitude/Longitude. ", description: "Enter a Zipcode For Location 1", required: false, defaultValue: "10001"
  		input name: "location1Name", type: "string", title: "Enter A Name To Display For Location 1", description: "Enter a Name For Your Zipcode", required: false, defaultValue: "New York"
     	input name: "location2Zip", type: "string", title: "Enter A Zip Code For Location 2. For the US you can use zipcode, State/City or Latitude/Longitude.  If using outside the US Try UK/city or Latitude/Longitude.", description: "Enter a Zipcode For Location 2.", required: false, defaultValue: "60920"
  		input name: "location2Name", type: "string", title: "Enter A Name To Display For Location 2", description: "Enter a Name For Your Zipcode", required: false, defaultValue: "Chicago"
		input name: "location3Zip", type: "string", title: "Enter A Zip Code For Location 3.  For the US you can use zipcode, State/City or Latitude/Longitude.  If using outside the US Try UK/city or Latitude/Longitude.", description: "Enter a Zipcode For Location 3.", required: false, defaultValue: "90001"
        input name: "location3Name", type: "string", title: "Enter A Name To Display For Location 3.", description: "Enter a Name For Your Zipcode", required: false, defaultValue: "Los Angeles"
        input ("measUnits", "enum", title: "Measuerment units", required: false, defaultValue:"imperial",
			options: [ "imperial":"Imperial", "metric":"Metric" ])
    	input ("timeFormat", "enum", title: "Time Format", required: false, defaultValue: "12Hour",
			options: [ "12Hour":"12 Hour Format, i.e. 01:00 PM", "24Hour":"24 Hour Format, i.e. 13:00 PM" ])
        input ("runEvery", "enum", title: "How often to update weather results", required: false, defaultValue: "3 hours", 
        	options: [ "1 minute":"1 minute" , "5 minutes":"5 minutes" , "10 minutes":"10 minutes","15 minutes":"15 minutes","30 minutes":"30 minutes","1 hour":"1 hour","3 hours":"3 hours"])
       	input "weather", "device.smartweatherStationTile", title: "Weather...", multiple: true, required: false
    }
    tiles(scale:2) {
  		multiAttributeTile(name:"temperature", type:"generic", width:1, height:1, canChangeIcon: false) {
	       	tileAttribute("device.tempTile", key: "PRIMARY_CONTROL") {
                    attributeState("temperature" ,label:'${currentValue}',
                    backgroundColors:[	
                /*Celsius
                    [value: 0, color: "#153591"],
					[value: 7, color: "#1e9cbb"],
					[value: 15, color: "#90d2a7"],
					[value: 23, color: "#44b621"],
					[value: 28, color: "#f1d801"],
					[value: 35, color: "#d04e00"],
					[value: 37, color: "#bc2323"],
                   */
                    // Farenheight
                    [value: 40, color: "#153591"],
					[value: 44, color: "#1e9cbb"],
					[value: 59, color: "#90d2a7"],
					[value: 74, color: "#44b621"],
					[value: 84, color: "#f1d801"],
					[value: 95, color: "#d04e00"],
					[value: 96, color: "#bc2323"],]
                    )
                }
			//tileAttribute("device.city", key: "SECONDARY_CONTROL") {
            //	attributeState("default", label:'											${currentValue}') }
  	        tileAttribute("device.feelsLike", key: "SECONDARY_CONTROL") {
                attributeState("default", label:'Feels Like ${currentValue}°') }
     		}  
 		multiAttributeTile(name:"temperatureM", type:"generic", width:1, height:1, canChangeIcon: false) {
	       	tileAttribute("device.tempTile", key: "PRIMARY_CONTROL") {
                    attributeState("temperature" ,label:'${currentValue}',
                    backgroundColors:[	
                //Celsius
                    [value: 0, color: "#153591"],
					[value: 7, color: "#1e9cbb"],
					[value: 15, color: "#90d2a7"],
					[value: 23, color: "#44b621"],
					[value: 28, color: "#f1d801"],
					[value: 35, color: "#d04e00"],
					[value: 37, color: "#bc2323"],]
                   
                  /*  // Farenheight
                    [value: 40, color: "#153591"],
					[value: 44, color: "#1e9cbb"],
					[value: 59, color: "#90d2a7"],
					[value: 74, color: "#44b621"],
					[value: 84, color: "#f1d801"],
					[value: 95, color: "#d04e00"],
					[value: 96, color: "#bc2323"],]
                    */
                    )
                }
			tileAttribute("device.city", key: "SECONDARY_CONTROL") {
            	attributeState("default", label:'											${currentValue}') }
  	      	tileAttribute("device.feelsLike", key: "SECONDARY_CONTROL") {
                attributeState("default", label:'Feels Like ${currentValue}°') }
     	} 
        standardTile("weatherIcon", "device.weatherIcon", decoration: "flat") {
            state "chanceflurries", icon:"st.custom.wu1.chanceflurries", label: ""
            state "chancerain", icon:"st.custom.wu1.chancerain", label: ""
            state "chancesleet", icon:"st.custom.wu1.chancesleet", label: ""
            state "chancesnow", icon:"st.custom.wu1.chancesnow", label: ""
            state "chancetstorms", icon:"st.custom.wu1.chancetstorms", label: ""
            state "clear", icon:"st.custom.wu1.clear", label: ""
            state "cloudy", icon:"st.custom.wu1.cloudy", label: ""
            state "flurries", icon:"st.custom.wu1.flurries", label: ""
            state "fog", icon:"st.custom.wu1.fog", label: ""
            state "hazy", icon:"st.custom.wu1.hazy", label: ""
            state "mostlycloudy", icon:"st.custom.wu1.mostlycloudy", label: ""
            state "mostlysunny", icon:"st.custom.wu1.mostlysunny", label: ""
            state "partlycloudy", icon:"st.custom.wu1.partlycloudy", label: ""
            state "partlysunny", icon:"st.custom.wu1.partlysunny", label: ""
            state "rain", icon:"st.custom.wu1.rain", label: ""
            state "sleet", icon:"st.custom.wu1.sleet", label: ""
            state "snow", icon:"st.custom.wu1.snow", label: ""
            state "sunny", icon:"st.custom.wu1.sunny", label: ""
            state "tstorms", icon:"st.custom.wu1.tstorms", label: ""
            state "cloudy", icon:"st.custom.wu1.cloudy", label: ""
            state "partlycloudy", icon:"st.custom.wu1.partlycloudy", label: ""
            state "nt_chanceflurries", icon:"st.custom.wu1.nt_chanceflurries", label: ""
            state "nt_chancerain", icon:"st.custom.wu1.nt_chancerain", label: ""
            state "nt_chancesleet", icon:"st.custom.wu1.nt_chancesleet", label: ""
            state "nt_chancesnow", icon:"st.custom.wu1.nt_chancesnow", label: ""
            state "nt_chancetstorms", icon:"st.custom.wu1.nt_chancetstorms", label: ""
            state "nt_clear", icon:"st.custom.wu1.nt_clear", label: ""
            state "nt_cloudy", icon:"st.custom.wu1.nt_cloudy", label: ""
            state "nt_flurries", icon:"st.custom.wu1.nt_flurries", label: ""
            state "nt_fog", icon:"st.custom.wu1.nt_fog", label: ""
            state "nt_hazy", icon:"st.custom.wu1.nt_hazy", label: ""
            state "nt_mostlycloudy", icon:"st.custom.wu1.nt_mostlycloudy", label: ""
            state "nt_mostlysunny", icon:"st.custom.wu1.nt_mostlysunny", label: ""
            state "nt_partlycloudy", icon:"st.custom.wu1.nt_partlycloudy", label: ""
            state "nt_partlysunny", icon:"st.custom.wu1.nt_partlysunny", label: ""
            state "nt_sleet", icon:"st.custom.wu1.nt_sleet", label: ""
            state "nt_rain", icon:"st.custom.wu1.nt_rain", label: ""
            state "nt_sleet", icon:"st.custom.wu1.nt_sleet", label: ""
            state "nt_snow", icon:"st.custom.wu1.nt_snow", label: ""
            state "nt_sunny", icon:"st.custom.wu1.nt_sunny", label: ""
            state "nt_tstorms", icon:"st.custom.wu1.nt_tstorms", label: ""
            state "nt_cloudy", icon:"st.custom.wu1.nt_cloudy", label: ""
            state "nt_partlycloudy", icon:"st.custom.wu1.nt_partlycloudy", label: ""
     	}
        valueTile("lastSTupdate", "device.lastSTupdate", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state("default", label: 'Last Updated\n ${currentValue}')
        }
        valueTile("humidity", "device.humidity", inactiveLabel: false, width: 1, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Humidity ${currentValue}%', unit:"%"
        }
        valueTile("weather", "device.weather", inactiveLabel: false, width: 1, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'${currentValue}'
        }
        valueTile("percentPrecip", "device.percentPrecip", inactiveLabel: false, width: 1, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Rain\n ${currentValue}%'
        }
        valueTile("PrecipToday", "device.precipToday", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Rain Today\n ${currentValue}'
        }
        valueTile("PrecipLastHour", "device.precipLastHour", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Rain Last Hour\n ${currentValue}'
        }
        standardTile("refresh", "device.weather", inactiveLabel: false, width: 1, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label: "", action: "poll", icon:"st.secondary.refresh"
        }
        standardTile("alert", "device.alert", inactiveLabel: false, width: 4, height: 2, decoration: "flat", wordWrap: true) {
      		state "[null]",icon:"https://raw.github.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/Default.png"
     		state "[WIN]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/WIN.png"
     		state "[TOR]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/TOR.png"
       		state "[TOW]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/TOW.png"
      		state "[WRN]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/WRN.png"
       		state "[SEW]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/SEW.png"
     		state "[FLO]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/FLO.png"
      		state "[WAT]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/WAT.png"
    		state "[WND]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/WND.png"
       		state "[SVR]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/SVR.png"
    		state "[HEA]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/HEA.png"
     		state "[FOG]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/FOG.png"
    		state "[SPE]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/SPE.png"     
    		state "[FIR]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/FIR.png"
    	    state "[VOL]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/VOL.png"
       		state "[HWW]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/HWW.png"
       		state "[REC]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/REC.png"
       		state "[REP]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/REP.png"
       		state "[PUB]",icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Alert%20Icons/PUB.png"
       }
       standardTile("ForecastGraphic", "device.ForecastGraphic", inactiveLabel: false, width: 4, height: 2, decoration: "flat", wordWrap: true) {
       		state "[null]",icon:"https://www.theweather.com/wimages/fotoba7037436d671b4cbf1465324d987c6b.png"
    	}
      	valueTile("alertMessage", "device.alertMessage", inactiveLabel: false, width: 6, height: 6, decoration: "flat", wordWrap: true) {
            state "default", label:'Weather Alert Message :\n ${currentValue}'
    	}
      	valueTile("rise", "device.localSunrise", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Sunrise\n ${currentValue}'
        }
        valueTile("set", "device.localSunset", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Sunset\n ${currentValue}'
        }
        valueTile("light", "device.illuminance", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'${currentValue} lux'
        }
        valueTile("visibility", "device.visibility", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Visibility\n ${currentValue}'
        }
        valueTile("uv_index", "device.uv_index", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "uv_index", label: 'UV Index ${currentValue}', unit: "UV Index"
        }
       standardTile("water", "device.water", inactiveLabel: false, width: 1, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label: 'updating...', icon: "st.unknown.unknown.unknown"
            state "true", icon: "st.alarm.water.wet", backgroundColor:"#ff9999"
            state "false", icon: "st.alarm.water.dry", backgroundColor:"#ffffff"
        }
        valueTile("dewpoint", "device.dewPoint", inactiveLabel: false, width: 1, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Dewpoint ${currentValue}°'
        }
        valueTile("pressure", "device.pressureTrend", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "pressureTrend", label: 'Barometric Pressure ${currentValue}'
        }
        valueTile("windinfo", "device.windString", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "windString", label: 'Wind ${currentValue}'
        }
        valueTile("windChill", "device.windChill", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
         	state "windChill", label: 'wind chill \n ${currentValue} °',
         		backgroundColors:[
					[value: 32, color: "#153591"],
					[value: 44, color: "#1e9cbb"],
					[value: 59, color: "#90d2a7"],
					[value: 74, color: "#44b621"],
					[value: 84, color: "#f1d801"],
					[value: 92, color: "#d04e00"],
					[value: 98, color: "#bc2323"] 
                    ]
   		}
        valueTile("temperature2", "device.temperature", width: 2, height: 1, canChangeIcon: false , canChangeBackground:true){
         	state "temperature", label: '${currentValue}°',
				backgroundColors:[
					[value: 32, color: "#153591"],
					[value: 44, color: "#1e9cbb"],
					[value: 59, color: "#90d2a7"],
					[value: 74, color: "#44b621"],
					[value: 84, color: "#f1d801"],
					[value: 92, color: "#d04e00"],
					[value: 98, color: "#bc2323"]
            	]
        }
    	standardTile("Blank", "device.blank", width: 2, height: 2,  inactiveLabel: false, decoration: "flat") 
  		
    	standardTile("loc1", "device.loc1", width: 2, height: 1, inactiveLabel: false, decoration: "flat") {
			state "active", action:"loc1", icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Location%20Icons/Location%201%20Active.png"
	   		state "inactive", action:"loc1", icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Location%20Icons/Location%201%20Inactive.png"
		}
        standardTile("loc1Name", "device.loc1Name", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
         state "${location1Name}", label: '${currentValue}'
        }
		standardTile("loc2", "device.loc2", width: 2, height: 1, inactiveLabel: false, decoration: "flat") {
			state "active", action:"loc2", icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Location%20Icons/Location%202%20%20Active.png"
          	state "inactive", action:"loc2", icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Location%20Icons/Location%202%20Inactive.png"
	    }
   		standardTile("loc2Name", "device.loc2Name", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
       		state "${location2Name}", label: '${currentValue}'
     	}   
		standardTile("loc3", "device.loc3", width: 2, height: 1, inactiveLabel: false, decoration: "flat",backgroundcolor: "#bc2323"   ) {
			state "active", action:"loc3", icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Location%20Icons/Location%203%20Active.png"
          	state "inactive", action:"loc3", icon:"https://raw.githubusercontent.com/Gopack2/A-Better-Weather-Tile-1.0/master/Location%20Icons/Location%203%20Inactive.png"
	    }   
         standardTile("loc3Name", "device.loc3Name", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
         	state "${locationName}",label: '${currentValue}'
        }

 main ("temperature2")
         //details(["alert", "loc1","loc2","loc3","loc1Name","loc2Name","loc3Name","temperature", "weatherIcon","weather","humidity" , "dewpoint", "windinfo", "pressure", "solarradiation","light", "city", "rise", "set", "lastSTupdate", "percentPrecip", "PrecipToday","PrecipLastHour", "water", "refresh"])
 		details(["loc1","loc2","loc3","loc1Name","loc2Name","loc3Name","alert","temperature", "weatherIcon","weather","water", "refresh","humidity" ,  "dewpoint", "windinfo", "pressure", "rise", "set", "lastSTupdate", "percentPrecip", "PrecipToday","PrecipLastHour"])
 		}
}
// parse events into attributes
def parse(String description) {
    log.debug "Parsing '${description}'"
	}
def installed() {
	
	}

def uninstalled() {
	unschedule()
	}
def initialize() {
sendEvent("name":"Zip","value":location1Zip)
    sendEvent("name":"defaultZip","value":location1Zip)
    sendEvent("name":"loc1Overide","value":"false")
    sendEvent(name:"loc1Name",value:location1Name)
    sendEvent(name:"loc2Name",value:location2Name)
    sendEvent(name:"loc3Name",value:location3Name)
  	switch (runEvery) {       
       	case "1 minute" :
        	runEvery1Minute(poll)
        	break;
		case "5 minutes" :
       		runEvery5Minutes(poll)
        	break;
        case "10 minutes" :
       		runEvery10Minutes(poll)
        	break;
        case "15 minutes" :
       		runEvery15Minutes(poll)
        	break;
        case "30 minutes" :
       		runEvery30Minutes(poll)
        	break;
        case "1 hour" :
       		runEvery1Hour(poll)
        	break;
        case "3 hours" :
       		runEvery3Hours(poll)
        	break;
        default :
        	runEvery15Minutes(poll)
    	}
    }
def updated() {
	log.debug" location 1 zip is $location1Zip"
    log.debug "overide has been turned to $state.loc1Overide "
    state.loc1Overide = "false"
    state.defaultLocation1Zip = "location1Zip"
    //log.debug "overide has been turned to $state.loc1Overide "
    
    log.debug "UPDATED!"
    //unschedule()
    //sendEvent("name":"Zip","value":"")
    sendEvent("name":"Zip","value":location1Zip)
    sendEvent("name":"defaultZip","value":location1Zip)
    sendEvent("name":"loc1Overide","value":"false")
    sendEvent(name:"loc1Name",value:location1Name)
    sendEvent(name:"loc2Name",value:location2Name)
    sendEvent(name:"loc3Name",value:location3Name)
  	switch (runEvery) {       
       	case "1 minute" :
        	runEvery1Minute(poll)
        	break;
		case "5 minutes" :
       		runEvery5Minutes(poll)
        	break;
        case "10 minutes" :
       		runEvery10Minutes(poll)
        	break;
        case "15 minutes" :
       		runEvery15Minutes(poll)
        	break;
        case "30 minutes" :
       		runEvery30Minutes(poll)
        	break;
        case "1 hour" :
       		runEvery1Hour(poll)
        	break;
        case "3 hours" :
       		runEvery3Hours(poll)
        	break;
        default :
        	runEvery15Minutes(poll)
    	}
	}
def loc1ChangeDefaultZip (param1) {
   	//sendEvent("name":"Zip", "value":param1)
    state.mobileZip = param1
    state.loc1Overide = "true"
} 
def loc1RestoreDefaultZip() {
	sendEvent("name":"Zip", "value": location1Zip)
    state.loc1Overide = "false"
}
// My City Button Controls
def loc1() {
state.tileLocName = location1Name
	switch (state.loc1Overide) {
    	case "false":
            sendEvent(name: "city", "value":location1Name, displayed: false)   
            sendEvent(name:"Zip","value":location1Zip, displayed: false)
            sendEvent(name:"loc3",value:"inactive", displayed: false)
            sendEvent(name:"loc2",value:"inactive", displayed: false)
            sendEvent(name:"loc1",value: "active" , displayed: false)
            poll()
            break;
    	case"true":
            
            sendEvent(name: "city", "value":location1Name, displayed: false)   
            sendEvent(name:"Zip","value": state.mobileZip , displayed: false)
            sendEvent(name:"loc3",value:"inactive", displayed: false)
            sendEvent(name:"loc2",value:"inactive", displayed: false)
            sendEvent(name:"loc1",value: "active" , displayed: false)
            poll()
            break;
        default :
            sendEvent(name: "city", "value":location1Name, displayed: false)   
            sendEvent(name:"Zip","value":location1Zip, displayed: false)
            sendEvent(name:"loc3",value:"inactive", displayed: false)
            sendEvent(name:"loc2",value:"inactive", displayed: false)
            sendEvent(name:"loc1",value: "active" , displayed: false)
            poll()
    	}
	}
def loc2() {
state.tileLocName = location2Name
	sendEvent(name: "city", value:location2Name, displayed: false)
    sendEvent(name:"Zip","value":location2Zip, displayed: false)
    sendEvent(name:"loc3",value:"inactive", displayed: false)
 	sendEvent(name:"loc1",value:"inactive" , displayed: false)
	sendEvent(name:"loc2",value:"active", displayed: false)
  	poll()
	}
def loc3() {
state.tileLocName = location3Name
   	sendEvent(name: "city", value: location3Name, displayed: false)
    sendEvent(name:"Zip","value":location3Zip, displayed: false)
    sendEvent(name:"loc2",value:"inactive", displayed: false)
    sendEvent(name:"loc1",value:"inactive", displayed: false)
    sendEvent(name:"loc3",value:"active", displayed: false)
    poll()
	}
def poll() {
    log.debug "WUSTATION: Executing 'poll', location: ${location.name}"
//   	clearAttributeStates
// 		clear attributes
//		clearAttributeStates()
// Current conditions
    def obs = get("conditions")?.current_observation
    if (obs) {
  		//log.debug "obs --> ${obs}"
        def now = new Date().format('M/d/yyyy h:mm a ',location.timeZone)
        	sendEvent(name:"lastSTupdate", value: now, displayed: true)
      	def weatherIcon = obs.icon_url.split("/")[-1].split("\\.")[0]
		def pressure_trend_text
        	switch (obs.pressure_trend) {
        		case "-" :
            		pressure_trend_text = "Falling"
            		break;
        		case "+":
            		pressure_trend_text = "Rising"
            		break;
        		case "=":
            		pressure_trend_text = "Steady"
            		break;
        		case "0":
            		pressure_trend_text = "No Change"
            		break;
        		default:
            		pressure_trend_text = "N/A"
        	}
		if (measUnits) {
            switch (measUnits) {
            	case "imperial" :
            			def Temp = Math.round(obs.temp_f)
                        send(name: "tempTile", value: "${Temp}°F \n ${state.tileLocName}" , displayed: false)
                        send(name: "temperature", value: Math.round(obs.temp_f) , unit: "° F", displayed: false)
            			send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F", displayed: false)
            			send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F", displayed: false)
          			if ( obs.windchill_f == "NA") (
          				send(name: "windChill", value: "--", displayed: false))
          			else ( 
                		send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "° F", displayed: false)
          			)
          			if ( obs.heat_index_f == "NA") (
                		send(name: "heatIndex", value: "--", displayed: false))
                	else (send(name: "heatIndex", value: obs.heat_index_f, displayed: false)
                	)
                		send(name: "pressureTrend", value: "${obs.pressure_in} inches \n and (${pressure_trend_text})", displayed: false)
                		send(name: "pressure", value: "${obs.pressure_in}",unit:" inches", displayed: false)
                		send(name: "visibility", value: "${obs.visibility_mi}",unit:" mi", displayed: false)
                		send(name: "precipToday", value: "${obs.precip_today_in} Inches",unit:" in", displayed: false)
                	if (obs.precip_1hr_in.toFloat() > 0) {
            			sendEvent( name: 'water', value: "true" , displayed: false)
            			send(name: "precipLastHour", value: "${obs.precip_1hr_in}",unit:" in", displayed: false)
        			} 
                    else {
            			sendEvent( name: 'water', value: "false" , displayed: false)
            			send(name: "precipLastHour", value: "0.00",unit:" in", displayed: false)
        			}
             			send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)", displayed: false)
                		send(name: "wind_gust", value: "${obs.wind_gust_mph}",unit:" mph", displayed: false)
                		send(name: "winddirection", value: "${obs.wind_dir}", displayed: false)
                		send(name: "winddirection_deg", value: "${obs.wind_degrees}",unit:"°", displayed: false)
                		send(name: "wind", value: "${obs.wind_mph}",unit:" mph", displayed: false)
                break;
            case "metric":
                		def Temp = Math.round(obs.temp_c)
                        send(name: "tempTile", value: "${Temp}°C \n ${state.tileLocName}" , displayed: false)
                        send(name: "temperature", value: Math.round(obs.temp_c), unit: "° C", displayed: false)
            			send(name: "feelsLike", value: Math.round(obs.feelslike_c as Double), unit: "° C", displayed: false)
            			send(name: "dewPoint", value: Math.round(obs.dewpoint_c as Double), unit: "° C", displayed: false)
            		if ( obs.windchill_c== "NA") (
          				send(name: "windChill", value: "--", displayed: false))
          			else ( send(name: "windChill", value: Math.round(obs.windchill_c as Double), unit: "°C", displayed: false)
          			)
   		 			if ( obs.heat_index_c == "NA") (
                		send(name: "heatIndex", value: "--", displayed: false))
                	else (send(name: "heatIndex", value: obs.heat_index_c, displayed: false)
                	)
                		send(name: "pressureTrend", value: "${obs.pressure_mb} mbar (${pressure_trend_text})", displayed: false)
                		send(name: "pressure", value: "${obs.pressure_mb}",unit:" mbar ", displayed: false)
                		send(name: "visibility", value: "${obs.visibility_km}",unit:" km", displayed: false)
                		send(name: "precipToday", value: "${obs.precip_today_metric}",unit:" mm", displayed: false)
                	if (obs.precip_1hr_in.toFloat() > 0) {
            			sendEvent( name: 'water', value: "true" , displayed: false)
            			send(name: "precipLastHour", value: "${obs.precip_1hr_metric}", displayed: false)
        			} 
                    else {
            			sendEvent( name: 'water', value: "false" , displayed: false)
            			send(name: "precipLastHour", value: "0.00", displayed: false)
        			}
                		send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_kph} kph\n(Gust: ${obs.wind_gust_kph} kph)", displayed: false)
                		send(name: "wind_gust", value: "${obs.wind_gust_kph}",unit:" kph", displayed: false)
                		send(name: "winddirection", value: "${obs.wind_dir}", displayed: false)
                		send(name: "winddirection_deg", value: "${obs.wind_degrees}",unit:"°", displayed: false)
                		send(name: "wind", value: "${obs.wind_kph}",unit:" kph", displayed: false)
                break;
            default:
            			def Temp = Math.round(obs.temp_f)
                        send(name: "tempTile", value: "${Temp}°F \n ${state.tileLocName}" , displayed: false)
                        send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F", displayed: false)
            			send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F", displayed: false)
            			send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F", displayed: false)
           				send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "°F", displayed: false)
  		 				send(name: "heatIndex", value: obs.heat_index_f, displayed: false)
                		send(name: "pressureTrend", value: "${obs.pressure_in} inches \n and (${pressure_trend_text})", displayed: false)
                		send(name: "pressure", value: "${obs.pressure_in}",unit:" inches ", displayed: false)
                		send(name: "visibility", value: "${obs.visibility_mi}",unit:" mi", displayed: false)
                		send(name: "precipToday", value: "${obs.precip_today_in}",unit:" in", displayed: false)
                	if (obs.precip_1hr_in.toFloat() > 0) {
            			sendEvent( name: 'water', value: "true" , displayed: false)
            			send(name: "precipLastHour", value: "${obs.precip_1hr_in}", displayed: false)
        			} 
                    else {
            			sendEvent( name: 'water', value: "false" , displayed: false)
            			send(name: "precipLastHour", value: "0.00", displayed: false)
        			}
                		send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)", displayed: false)
                		send(name: "wind_gust", value: "${obs.wind_gust_mph}",unit:" mph", displayed: false)
                		send(name: "winddirection", value: "${obs.wind_dir}", displayed: false)
                		send(name: "winddirection_deg", value: "${obs.wind_degrees}",unit:"°", displayed: false)
                		send(name: "wind", value: "${obs.wind_mph}",unit:" mph", displayed: false)
                	}
        		} 
          				send(name: "tempString", value: obs.temperature_string, displayed: false)
 						send(name: "precipLastHourString", value: "${obs.precip_1hr_string}", displayed: false)
                		send(name: "precipTodayString", value: "${obs.precip_today_string}", displayed: false)
			 			send(name: "windString", value: "${obs.wind_string}", displayed: false)
 						send(name: "fullLocation", value: obs.display_location.full, displayed: false)
        				send(name: "state", value: obs.display_location.state, displayed: false)
        				send(name: "city", value: obs.display_location.city, displayed: false)
        				send(name: "country", value: obs.display_location.country, displayed: false)
        				send(name: "humidity", value: obs.relative_humidity[0..-2] as Integer, unit: "%", displayed: false)
        				send(name: "weather", value: obs.weather, displayed: false)
        				send(name: "weatherIcon", value: weatherIcon, displayed: false)
        				send(name: "uv_index", value: obs.UV, displayed: false)
        				send(name: "latitude", value: obs.observation_location.latitude, displayed: false)
        				send(name: "longitude", value: obs.observation_location.longitude, displayed: false)
        				send(name: "elevation", value: obs.observation_location.elevation, displayed: false)
        				send(name: "observationTime", value: obs.observation_time, displayed: false)
        				send(name: "observationEpoch", value: obs.observation_epoch, displayed: false)
          			if (obs.local_tz_offset != device.currentValue("timeZoneOffset")) {
            			send(name: "timeZoneOffset", value: obs.local_tz_offset, isStateChange: true, displayed: false)
        			}
// Sunrise / sunset
 	def astro = get("astronomy")?.moon_phase
     	switch (timeFormat) {
        	case "12Hour" :
        		send(name: "localSunset", value: Date.parse("HH:mm","${astro.sunset.hour}:${astro.sunset.minute}").format( 'h:mm a ' ), displayed: false)
     			send(name: "localSunrise", value: Date.parse("HH:mm","${astro.sunrise.hour}:${astro.sunrise.minute}").format( 'h:mm a' ), displayed: false)
        		send(name: "localMoonset", value: Date.parse("HH:mm","${astro.moonset.hour}:${astro.moonset.minute}").format( 'h:mm a ' ), displayed: false)
     			send(name: "localMoonrise", value: Date.parse("HH:mm","${astro.moonrise.hour}:${astro.moonrise.minute}").format( 'h:mm a' ), displayed: false)
    			break;
			case "24Hour" :
        		send(name: "localSunset", value: Date.parse("HH:mm","${astro.sunset.hour}:${astro.sunset.minute}").format( 'HH:mm ' ), displayed: false)
     			send(name: "localSunrise", value: Date.parse("HH:mm","${astro.sunrise.hour}:${astro.sunrise.minute}").format( 'HH:mm ' ), displayed: false)
        		send(name: "localMoonset", value: Date.parse("HH:mm","${astro.moonset.hour}:${astro.moonset.minute}").format( 'HH:mm ' ), displayed: false)
     			send(name: "localMoonrise", value: Date.parse("HH:mm","${astro.moonrise.hour}:${astro.moonrise.minute}").format( 'HH:mm ' ), displayed: false)
  				break;
        	default :
        		send(name: "localSunset", value: Date.parse("HH:mm","${astro.sunset.hour}:${astro.sunset.minute}").format( 'h:mm a ' ), displayed: false)
     				send(name: "localSunrise", value: Date.parse("HH:mm","${astro.sunrise.hour}:${astro.sunrise.minute}").format( 'h:mm a' ), displayed: false)
        		send(name: "localMoonset", value: Date.parse("HH:mm","${astro.moonset.hour}:${astro.moonset.minute}").format( 'h:mm a ' ), displayed: false)
     			send(name: "localMoonrise", value: Date.parse("HH:mm","${astro.moonrise.hour}:${astro.moonrise.minute}").format( 'h:mm a' ), displayed: false)
    	}
// Forecast
 	def f = get("forecast10day")
   	def f1= f?.forecast?.txt_forecast?.forecastday
        if (f1) {
            def icon = f1[0].icon_url.split("/")[-1].split("\\.")[0]
            def value = f1[0].pop as String // as String because of bug in determining state change of 0 numbers
            	send(name: "percentPrecip", value: value, unit: "%", displayed:false)
            	send(name: "forecastIcon", value: icon, displayed: false)
            switch(measUnits) {
                case "imperial" :
             	  	send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext} .... ${f1[13].title}: ${f1[13].fcttext} ", displayed: false)
             		send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext} .... ${f1[11].title}: ${f1[11].fcttext} ", displayed: false)
					send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} ", displayed: false)
                   	send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} ", displayed: false)
                   	send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} ", displayed: false)
                  	send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} ", displayed: false)
                	send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} ", displayed: false)
                    send(name: "Forecast7Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} .... ${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} .... ${f1[10].title}: ${f1[10].fcttext} .... ${f1[11].title}: ${f1[11].fcttext} .... ${f1[12].title}: ${f1[12].fcttext} .... ${f1[13].title}: ${f1[13].fcttext} ", displayed: false) 
                    send(name: "Forecast6Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} .... ${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} .... ${f1[10].title}: ${f1[10].fcttext} .... ${f1[11].title}: ${f1[11].fcttext} ", displayed: false)    
                    send(name: "Forecast5Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} .... ${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} ", displayed: false)
                    send(name: "Forecast4Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} ", displayed: false)
                    send(name: "Forecast3Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} ", displayed: false) 
                    send(name: "Forecast2Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} ", displayed: false)
                    send(name: "Forecast1Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} ", displayed: false)
                    break;
            	case "metric" :
                    send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext_metric} .... ${f1[13].title}: ${f1[13].fcttext_metric} ", displayed: false)
                    send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext_metric} .... ${f1[11].title}: ${f1[11].fcttext_metric} ", displayed: false)
                    send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext_metric} .... ${f1[9].title}: ${f1[9].fcttext_metric} ", displayed: false)
                    send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext_metric} .... ${f1[7].title}: ${f1[7].fcttext_metric} ", displayed: false)
                    send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext_metric} .... ${f1[5].title}: ${f1[5].fcttext_metric} ", displayed: false)
                    send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} ", displayed: false)
                    send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} ", displayed: false)
                    send(name: "Forecast7Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} .... ${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} .... ${f1[4].title}: ${f1[4].fcttext_metric} .... ${f1[5].title}: ${f1[5].fcttext_metric} .... ${f1[6].title}: ${f1[6].fcttext_metric} .... ${f1[7].title}: ${f1[7].fcttext_metric} .... ${f1[8].title}: ${f1[8].fcttext_metric} .... ${f1[9].title}: ${f1[9].fcttext_metric} .... ${f1[10].title}: ${f1[10].fcttext_metric} .... ${f1[11].title}: ${f1[11].fcttext_metric} .... ${f1[12].title}: ${f1[12].fcttext_metric} .... ${f1[13].title}: ${f1[13].fcttext_metric} ", displayed: false) 
                    send(name: "Forecast6Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} .... ${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} .... ${f1[4].title}: ${f1[4].fcttext_metric} .... ${f1[5].title}: ${f1[5].fcttext_metric} .... ${f1[6].title}: ${f1[6].fcttext_metric} .... ${f1[7].title}: ${f1[7].fcttext_metric} .... ${f1[8].title}: ${f1[8].fcttext_metric} .... ${f1[9].title}: ${f1[9].fcttext_metric} .... ${f1[10].title}: ${f1[10].fcttext_metric} .... ${f1[11].title}: ${f1[11].fcttext_metric} ", displayed: false)    
                    send(name: "Forecast5Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} .... ${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} .... ${f1[4].title}: ${f1[4].fcttext_metric} .... ${f1[5].title}: ${f1[5].fcttext_metric} .... ${f1[6].title}: ${f1[6].fcttext_metric} .... ${f1[7].title}: ${f1[7].fcttext_metric} .... ${f1[8].title}: ${f1[8].fcttext_metric} .... ${f1[9].title}: ${f1[9].fcttext_metric} ", displayed: false)
                    send(name: "Forecast4Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} .... ${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} .... ${f1[4].title}: ${f1[4].fcttext_metric} .... ${f1[5].title}: ${f1[5].fcttext_metric} .... ${f1[6].title}: ${f1[6].fcttext_metric} .... ${f1[7].title}: ${f1[7].fcttext_metric} ", displayed: false)
                    send(name: "Forecast3Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} .... ${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} .... ${f1[4].title}: ${f1[4].fcttext_metric} .... ${f1[5].title}: ${f1[5].fcttext_metric} ", displayed: false) 
                    send(name: "Forecast2Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} .... ${f1[2].title}: ${f1[2].fcttext_metric} .... ${f1[3].title}: ${f1[3].fcttext_metric} ", displayed: false)
                    send(name: "Forecast1Day",value: "${f1[0].title}: ${f1[0].fcttext_metric} .... ${f1[1].title}: ${f1[1].fcttext_metric} ", displayed: false)
                    break;
          		default:
                    send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext} .... ${f1[13].title}: ${f1[13].fcttext} ", displayed: false)
                    send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext} .... ${f1[11].title}: ${f1[11].fcttext} ", displayed: false)
                    send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} ", displayed: false)
                    send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} ", displayed: false)
                    send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} ", displayed: false)
                    send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} ", displayed: false)
                    send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} ", displayed: false)
                    send(name: "Forecast7Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} .... ${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} .... ${f1[10].title}: ${f1[10].fcttext} .... ${f1[11].title}: ${f1[11].fcttext} .... ${f1[12].title}: ${f1[12].fcttext} .... ${f1[13].title}: ${f1[13].fcttext} ", displayed: false) 
                    send(name: "Forecast6Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} .... ${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} .... ${f1[10].title}: ${f1[10].fcttext} .... ${f1[11].title}: ${f1[11].fcttext} ", displayed: false)    
                    send(name: "Forecast5Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} .... ${f1[8].title}: ${f1[8].fcttext} .... ${f1[9].title}: ${f1[9].fcttext} ", displayed: false)
                    send(name: "Forecast4Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} .... ${f1[6].title}: ${f1[6].fcttext} .... ${f1[7].title}: ${f1[7].fcttext} ", displayed: false)
                    send(name: "Forecast3Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} .... ${f1[4].title}: ${f1[4].fcttext} .... ${f1[5].title}: ${f1[5].fcttext} ", displayed: false) 
                    send(name: "Forecast2Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} .... ${f1[2].title}: ${f1[2].fcttext} .... ${f1[3].title}: ${f1[3].fcttext} ", displayed: false)
                    send(name: "Forecast1Day",value: "${f1[0].title}: ${f1[0].fcttext} .... ${f1[1].title}: ${f1[1].fcttext} ", displayed: false)
                }
		}
        else {
            log.warn "Forecast not found"
        }
// yesterday information
	def yesterday = get("yesterday")?.history
    if (yesterday) {
            send(name:"yesterdayFog", value:"${yesterday.dailysummary[0].fog}", displayed: false)
            send(name:"yesterdayRain", value:"${yesterday.dailysummary[0].rain}", displayed: false)
            send(name:"yesterdaySnow", value:"${yesterday.dailysummary[0].snow}", displayed: false)
            send(name:"yesterdayHail", value:"${yesterday.dailysummary[0].hail}", displayed: false)
            send(name:"yesterdayThunder", value:"${yesterday.dailysummary[0].thunder}", displayed: false)
            send(name:"yesterdayTornado", value:"${yesterday.dailysummary[0].tornado}", displayed: false)
            send(name:"yesterdayAvgWindDird", value:"${yesterday.dailysummary[0].meanwindird}", displayed: false)
            send(name:"yesterdayMaxHumidity", value:"${yesterday.dailysummary[0].maxhumidity}", displayed: false)
            send(name:"yesterdayMinHumidity", value:"${yesterday.dailysummary[0].minhumidity}", displayed: false)
            send(name:"yesterdayGDegreeDays", value:"${yesterday.dailysummary[0].gdegreedays}", displayed: false)
            send(name:"yesterdayHeatingDegreeDays", value:"${yesterday.dailysummary[0].heatingdegreedays}", displayed: false)
            send(name:"yesterdayCoolingDegreeDays", value:"${yesterday.dailysummary[0].coolingdegreedays}", displayed: false)
            send(name:"yesterdayMonthToDateHeatingDegreeDays", value:"${yesterday.dailysummary[0].monthtodateheatingdegreedays}", displayed: false)
            send(name:"yesterdayMonthToDateHeatingDegreeDaysNormal", value:"${yesterday.dailysummary[0].monthtodateheatingdegreedaysnormal}", displayed: false)
	switch (measUnits) {
        case "imperial" :
        	send(name:"yesterdaySnowFall", value:"${yesterday.dailysummary[0].snowfalli}", displayed: false)
            send(name:"yesterdaySnowFallMonthToDate", value:"${yesterday.dailysummary[0].monthtodatesnowfalli}", displayed: false)
            send(name:"yesterdaySnowFallSinceJuly", value:"${yesterday.dailysummary[0].since1julsnowfalli}", displayed: false)
            send(name:"yesterdayAvgTemp", value:"${yesterday.dailysummary[0].meantempi}", displayed: false)
            send(name:"yesterdayAvgDewPt", value:"${yesterday.dailysummary[0].meandewpti}", displayed: false)
            send(name:"yesterdayAvgPressure", value:"${yesterday.dailysummary[0].meanpressurei}", displayed: false)
            send(name:"yesterdayAvgWindSpd", value:"${yesterday.dailysummary[0].meanwindspdi}", displayed: false)
            send(name:"yesterdayAvgWindDird", value:"${yesterday.dailysummary[0].meanwdird}", displayed: false)
            send(name:"yesterdayAvgVis", value:"${yesterday.dailysummary[0].meanvisi}", displayed: false)
            send(name:"yesterdayMaxTemp", value:"${yesterday.dailysummary[0].maxtempi}", displayed: false)
            send(name:"yesterdayMinTemp", value:"${yesterday.dailysummary[0].mintempi}", displayed: false)
            send(name:"yesterdayAvgPressure", value:"${yesterday.dailysummary[0].meanpressurei}", displayed: false)
            send(name:"yesterdayMaxDewPt", value:"${yesterday.dailysummary[0].maxdewpti}", displayed: false)
            send(name:"yesterdayMinDewPt", value:"${yesterday.dailysummary[0].mindewpti}", displayed: false)
            send(name:"yesterdayMaxPressure", value:"${yesterday.dailysummary[0].maxpressurei}", displayed: false)
            send(name:"yesterdayMinPressure", value:"${yesterday.dailysummary[0].minpressurei}", displayed: false)
            send(name:"yesterdayMaxWindSpd", value:"${yesterday.dailysummary[0].maxwspdi}", displayed: false)
            send(name:"yesterdayMinWindSpd", value:"${yesterday.dailysummary[0].minwspdi}", displayed: false)
            send(name:"yesterdayMaxVis", value:"${yesterday.dailysummary[0].maxvisi}", displayed: false)
            send(name:"yesterdayMinVis", value:"${yesterday.dailysummary[0].minvisi}", displayed: false) 
            send(name:"yesterdayPrecip", value:"${yesterday.dailysummary[0].precipi}", displayed: false)       
    		break;
        case "metric":
   			send(name:"yesterdaySnowFall", value:"${yesterday.dailysummary[0].snowfallm}", displayed: false)
            send(name:"yesterdaySnowFallMonthToDate", value:"${yesterday.dailysummary[0].monthtodatesnowfallm}", displayed: false)
            send(name:"yesterdaySnowFallSinceJuly", value:"${yesterday.dailysummary[0].since1julsnowfallm}", displayed: false)
   			send(name:"yesterdayAvgTemp", value:"${yesterday.dailysummary[0].meantempm}", displayed: false)
    		send(name:"yesterdayAvgDewPt", value:"${yesterday.dailysummary[0].meandewptm}", displayed: false)
   			send(name:"yesterdayAvgPressure", value:"${yesterday.dailysummary[0].meanpressurem}", displayed: false)
   			send(name:"yesterdayAvgWindSpd", value:"${yesterday.dailysummary[0].meanwindspdm}", displayed: false)
            send(name:"yesterdayAvgWindDird", value:"${yesterday.dailysummary[0].meanwdird}", displayed: false)
   			send(name:"yesterdayAvgVis", value:"${yesterday.dailysummary[0].meanvism}", displayed: false)
   			send(name:"yesterdayMaxTemp", value:"${yesterday.dailysummary[0].maxtempm}", displayed: false)
   			send(name:"yesterdayMinTemp", value:"${yesterday.dailysummary[0].mintempm}", displayed: false)
   			send(name:"yesterdayAvgPressure", value:"${yesterday.dailysummary[0].meanpressurem}", displayed: false)
    		send(name:"yesterdayMaxDewPt", value:"${yesterday.dailysummary[0].maxdewptm}", displayed: false)
   			send(name:"yesterdayMinDewPt", value:"${yesterday.dailysummary[0].mindewptm}", displayed: false)
   			send(name:"yesterdayMaxPressure", value:"${yesterday.dailysummary[0].maxpressurem}", displayed: false)
   			send(name:"yesterdayMinPressure", value:"${yesterday.dailysummary[0].minpressurem}", displayed: false)
   			send(name:"yesterdayMaxWindSpd", value:"${yesterday.dailysummary[0].maxwspdm}", displayed: false)
   			send(name:"yesterdayMinWindSpd", value:"${yesterday.dailysummary[0].minwspdm}", displayed: false)
   			send(name:"yesterdayMaxVis", value:"${yesterday.dailysummary[0].maxvism}", displayed: false)
   			send(name:"yesterdayMinVis", value:"${yesterday.dailysummary[0].minvism}", displayed: false)
     		send(name:"yesterdayPrecip", value:"${yesterday.dailysummary[0].precipm}", displayed: false)        
    		break;
        default:
         	send(name:"yesterdaySnowFall", value:"${yesterday.dailysummary[0].snowfalli}", displayed: false)
            send(name:"yesterdaySnowFallMonthToDate", value:"${yesterday.dailysummary[0].monthtodatesnowfalli}", displayed: false)
            send(name:"yesterdaySnowFallSinceJuly", value:"${yesterday.dailysummary[0].since1julsnowfalli}", displayed: false)
   			send(name:"yesterdayAvgTemp", value:"${yesterday.dailysummary[0].meantempi}", displayed: false)
    		send(name:"yesterdayAvgDewPt", value:"${yesterday.dailysummary[0].meandewpti}", displayed: false)
   			send(name:"yesterdayAvgPressure", value:"${yesterday.dailysummary[0].meanpressurei}", displayed: false)
   			send(name:"yesterdayAvgWindSpd", value:"${yesterday.dailysummary[0].meanwindspdi}", displayed: false)
            send(name:"yesterdayAvgWindDird", value:"${yesterday.dailysummary[0].meanwdird}", displayed: false)
   			send(name:"yesterdayAvgVis", value:"${yesterday.dailysummary[0].meanvisi}", displayed: false)
   			send(name:"yesterdayMaxTemp", value:"${yesterday.dailysummary[0].maxtempi}", displayed: false)
   			send(name:"yesterdayMinTemp", value:"${yesterday.dailysummary[0].mintempi}", displayed: false)
   			send(name:"yesterdayAvgPressure", value:"${yesterday.dailysummary[0].meanpressurei}", displayed: false)
    		send(name:"yesterdayMaxDewPt", value:"${yesterday.dailysummary[0].maxdewpti}", displayed: false)
   			send(name:"yesterdayMinDewPt", value:"${yesterday.dailysummary[0].mindewpti}", displayed: false)
   			send(name:"yesterdayMaxPressure", value:"${yesterday.dailysummary[0].maxpressurei}", displayed: false)
   			send(name:"yesterdayMinPressure", value:"${yesterday.dailysummary[0].minpressurei}", displayed: false)
   			send(name:"yesterdayMaxWindSpd", value:"${yesterday.dailysummary[0].maxwspdi}", displayed: false)
   			send(name:"yesterdayMinWindSpd", value:"${yesterday.dailysummary[0].minwspdi}", displayed: false)
   			send(name:"yesterdayMaxVis", value:"${yesterday.dailysummary[0].maxvisi}", displayed: false)
   			send(name:"yesterdayMinVis", value:"${yesterday.dailysummary[0].minvisi}", displayed: false)
     		send(name:"yesterdayPrecip", value:"${yesterday.dailysummary[0].precipi}", displayed: false)        
        }
    }
     
// Almanac
	def almanac = get("almanac")?.almanac
    	if(almanac) {
    		send(name:"almanacAirportCode", value:"${almanac.airport_code}", displayed: false)
     	switch (measUnits) {
        	case "imperial" :
                send(name:"almanacNormalTempHigh", value:"${almanac.temp_high.normal.F}", displayed: false)
                send(name:"almanacNormalTempHighRecord", value:"${almanac.temp_high.record.F}", displayed: false)
                send(name:"almanacNormalTempHighRecordYear", value:"${almanac.temp_high.recordyear}", displayed: false)
                send(name:"almanacNormalTempLow", value:"${almanac.temp_low.normal.F}", displayed: false)
                send(name:"almanacNormalTempLowRecord", value:"${almanac.temp_low.record.F}", displayed: false)
                send(name:"almanacNormalTempLowRecordYear", value:"${almanac.temp_low.recordyear}", displayed: false)
                break;
        case "metric":
                send(name:"almanacNormalTempHigh", value:"${almanac.temp_high.normal.C}", displayed: false)
                send(name:"almanacNormalTempHighRecord", value:"${almanac.temp_high.record.C}", displayed: false)
                send(name:"almanacNormalTempHighRecordYear", value:"${almanac.temp_high.recordyear}", displayed: false)
                send(name:"almanacNormalTempLow", value:"${almanac.temp_low.normal.C}", displayed: false)
                send(name:"almanacNormalTempLowRecord", value:"${almanac.temp_low.record.C}", displayed: false)
                send(name:"almanacNormalTempLowRecordYear", value:"${almanac.temp_low.recordyear}", displayed: false)
                break;
        default:
                send(name:"almanacNormalTempHigh", value:"${almanac.temp_high.normal.F}", displayed: false)
                send(name:"almanacNormalTempHighRecord", value:"${almanac.temp_high.record.F}", displayed: false)
                send(name:"almanacNormalTempHighRecordYear", value:"${almanac.temp_high.recordyear}", displayed: false)
                send(name:"almanacNormalTempLow", value:"${almanac.temp_low.normal.F}", displayed: false)
                send(name:"almanacNormalTempLowRecord", value:"${almanac.temp_low.record.F}", displayed: false)
                send(name:"almanacNormalTempLowRecordYear", value:"${almanac.temp_low.recordyear}", displayed: false)
       }
   }
// Alerts
	def alerts = get("alerts")?.alerts      
    def alertType = "[${alerts?.type[0]}]"
    def newKeys = alerts?.collect{it.type + it.date_epoch} ?: []
    //log.trace device.currentState("alertKeys")
    def oldKeys = device.currentState("alertKeys")?.jsonValue
    def noneString = "There Are No Current Weather Alerts"
    if (!newKeys && oldKeys == null) {
     	send(name: "alertKeys", value: newKeys.encodeAsJSON(), displayed: false)
        send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true, displayed: false)
        }
   	else if (newKeys != oldKeys) {
     	if (oldKeys == null) {
        	oldKeys = []
            }
            send(name: "alertKeys", value: newKeys.encodeAsJSON(), displayed: false)
           	def newAlerts = false
           	alerts.each {alert ->
           		if (!oldKeys.contains(alert.type + alert.date_epoch)) {
                 	def msg = "${alert.description} from ${alert.date} until ${alert.expires}"
                   	//send(name: "alert", value: pad(alert.description), descriptionText: msg, isStateChange: true)
                    send(name: "alertMessage",value: "${alert.message}",displayed: true)
                    sendEvent(name:"alert", value:"${alertType}", displayed: false)
                    newAlerts = true
                	}
            }

    	if (!newAlerts && device.currentValue("alert") != noneString) {
            send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true, displayed: false)
            send(name:"alertMessage",value:"", displayed: false)
        	}
    	}
	}
    else {
        log.warn "No response from Weather Underground API"
     	}
	}

def refresh() {
    poll()
	}

def configure() {
    poll()
	}

private pad(String s, size = 25) {
    def n = (size - s.size()) / 2
    if (n > 0) {
        def sb = ""
        n.times {sb += " "}
        sb += s
        n.times {sb += " "}
      	return sb
  		}
    else {
      return s
    }
}


private get(feature) {
 	getWeatherFeature(feature,"${device.currentValue("Zip")}") 
	}

private localDate(timeZone) {
    def df = new java.text.SimpleDateFormat("yyyy-MM-dd")
    df.setTimeZone(TimeZone.getTimeZone(timeZone))
    df.format(new Date())
	}

private send(map) {
    //log.debug "WUSTATION: event: $map"
    sendEvent(map)
    
}