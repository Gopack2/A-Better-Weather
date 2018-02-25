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

new
*/
metadata {
    definition (name: "My Weather Device 1.0", namespace: "aGOPACK2", author: "Gopack2") {
        capability "Illuminance Measurement"
        capability "Temperature Measurement"
        capability "Relative Humidity Measurement"
        capability "Sensor"
        capability "Polling"
		
        attribute "alert", "string"
        //attribute "alertIcon","string"
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
		attribute "fullLocation", "string"
        attribute "heatIndex","string"
     	attribute "latitude", "string"
 		attribute "localSunrise", "string"
        attribute "localSunset", "string"
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
        attribute "sunriseDate", "string"
        attribute "sunsetDate", "string"
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
        attribute "Zip","string"
         
        command "location1Zip"
      	command "location3Zip"
      	command "location2Zip"
       	command "refresh"
	
    }

    preferences {
        input name: "location1Zip", type: "number", title: "Zip Code", description: "Enter a Zipcode For Location", required: true
        input name: "location1Name", type: "string", title: "Name Of Location", description: "Enter a Name For Your Zipcode", required: true
 		input name: "location2Zip", type: "number", title: "Zip Code", description: "Enter a Zipcode For Location", required: true
        input name: "location2Name", type: "string", title: "Name Of Location", description: "Enter a Name For Your Zipcode", required: true
		input name: "location3Zip", type: "number", title: "Zip Code", description: "Enter a Zipcode For Location", required: true
        input name: "location3Name", type: "string", title: "Name Of Location", description: "Enter a Name For Your Zipcode", required: true
        input ("measUnits", "enum", title: "Measuerment units", required: false, 
			options: [ "imperial":"Imperial", "metric":"Metric" ])
    	input ("timeFormat", "enum", title: "Time Format", required: false, 
			options: [ "12Hour":"12 Hour Format, i.e. 01:00 PM", "24Hour":"24 Hour Format, i.e. 13:00 PM" ])
       	input "weather", "device.smartweatherStationTile", title: "Weather...", multiple: true, required: false
    }
    
    tiles {
  		multiAttributeTile(name:"temperature", type:"generic", width:1, height:1, canChangeIcon: false) {
	       	tileAttribute("device.temperature", key: "PRIMARY_CONTROL") {
                attributeState("temperature",label:'${currentValue}°' ,
					backgroundColors:[
					[value: 32, color: "#153591"],
					[value: 44, color: "#1e9cbb"],
					[value: 59, color: "#90d2a7"],
					[value: 74, color: "#44b621"],
					[value: 84, color: "#f1d801"],
					[value: 92, color: "#d04e00"],
					[value: 98, color: "#bc2323"],
                    ])
            }
			tileAttribute("device.city", key: "SECONDARY_CONTROL") {
            	attributeState("default", label:'											${currentValue}')
            }
  	          tileAttribute("device.feelsLike", key: "SECONDARY_CONTROL") {
                attributeState("default", label:'Feels Like ${currentValue}°')
            }
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
        valueTile("humidity", "device.humidity", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
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
            state "default", label: "", action: "refresh", icon:"st.secondary.refresh"
        }
        standardTile("alert", "device.alert", inactiveLabel: false, width: 5, height: 2, decoration: "flat", wordWrap: true) {
      		state "[null]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Default.png?raw=true", label:'\n${currentValue}'
     		state "[WIN]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/WIN.png?raw=true"
     		state "[TOR]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/TOR.png?raw=true"
       		state "[TOW]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/TOW.png?raw=true"
      		state "[WRN]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/WRN.png?raw=true"
       		state "[SEW]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/SEW.png?raw=true"
     		state "[FLO]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/FLO.png?raw=true"
      		state "[WAT]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/WAT.png?raw=true"
    		state "[WND]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/WND.png?raw=true"
       		state "[SVR]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/SVR.png?raw=true"
    		state "[HEA]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/HEA.png?raw=true"
     		state "[FOG]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/FOG.png?raw=true"
    		state "[SPE]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/SPE.png?raw=true"     
    		state "[FIR]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/FIR.png?raw=true"
    	    state "[VOL]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/VOL.png?raw=true"
       		state "[HWW]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/HWW.png?raw=true"
       		state "[REC]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/REC.png?raw=true"
       		state "[REP]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/REP.png?raw=true"
       		state "[PUB]",icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/PUB.png?raw=true"
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
            state "true",        icon: "st.alarm.water.wet",        backgroundColor:"#ff9999"
            state "false",       icon: "st.alarm.water.dry",        backgroundColor:"#ffffff"
        }
        valueTile("dewpoint", "device.dewPoint", inactiveLabel: false, width: 2, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Dewpoint ${currentValue}°'
        }
        valueTile("pressure", "device.pressureTrend", inactiveLabel: false, width: 3, height: 1, decoration: "flat", wordWrap: true) {
            state "pressureTrend", label: 'Barometric Pressure ${currentValue}'
        }
        valueTile("windinfo", "device.windString", inactiveLabel: false, width: 3, height: 1, decoration: "flat", wordWrap: true) {
            state "windString", label: 'Wind ${currentValue}'
        }
        valueTile("windChill", "device.windChill", inactiveLabel: false, width: 3, height: 1, decoration: "flat", wordWrap: true) {
         state "windChill", label: 'wind chill  ${currentValue} °'
        }
        
        valueTile("temperature2", "device.temperature", width: 1, height: 1, canChangeIcon: true) {
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
  standardTile("location1", "device.location1", width: 2, height: 2,  inactiveLabel: false, decoration: "flat") {
			state "${location1Name} active", action: "location1Zip", label:'${currentValue}', icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Lighthouse%20Active.png?raw=true"
          	state "${location1Name}\n inactive", action:"location1Zip",label: "Loc 1", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Lighthouse%20Inactive.png?raw=true"
	    }
		standardTile("location2", "device.location2", width: 2, height: 2,inactiveLabel: false,decoration: "flat" ) {
			state "active", label:"Loc 2", action:"location2Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Cabin%20Active.png?raw=true"
			state "inactive", label:"Loc 2", action:"location2Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Cabin%20Inactive.png?raw=true"
            }        
		standardTile("location3", "device.location3", width: 2, height: 2,inactiveLabel: false,decoration: "flat") {
			state "active", label:"Loc 3", action:"location3Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Arizona%20Active.png?raw=true"
			state "inactive", label:"Loc 3", action:"location3Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Arizona%20Inactiuve.png?raw=true"
        }   
        valueTile("forecast", "device.Forecast0", width: 6, height: 6, canChangeBackground: true) {
 		state "longitude", label: '${currentValue}'
 		}
		
        valueTile("forecast", "device.Forecast0", width: 6, height: 6, canChangeBackground: true) {
 		state "longitude", label: '${currentValue}'
 		}
    main(["temperature2"])
	      details(["alert", "location1","location2","location3","temperature", "feelslike","weatherIcon","weather"
        	, "humidity" , "dewpoint", "windinfo", "pressure", "solarradiation", "uv_index", 
          "light", "visibility", "city", "rise", "set", "lastSTupdate", "percentPrecip", "PrecipToday",
          "PrecipLastHour", "water", "refresh"])
	}
}
// parse events into attributes
def parse(String description) {
    log.debug "Parsing '${description}'"
}

def installed() {
	runEvery15Minutes(poll)
}

def uninstalled() {
	unschedule()
}

def updated() {
	log.debug "UPDATED!"
    //unschedule()
    sendEvent("name":"Zip","value":location1Zip)
	poll()
   	runEvery15Minutes(poll)
}
// My City Button Controls
def location1Zip() {
    sendEvent(name: "city", "value":location1Name)   
    sendEvent(name:"Zip","value":location1Zip)
    sendEvent(name:"location3",value:"${location2Name}\n inactive")
 	sendEvent(name:"location2",value:"${location3Name}\n inactive")
	sendEvent(name:"location1",value:"${location1Name}\n active")
    poll()
}
def location2Zip() {
    sendEvent(name: "city", value:"location2Zip")
    sendEvent(name:"Zip","value":location2Zip)
    sendEvent(name:"location3",value:"${location3Name}\n inactive")
 	sendEvent(name:"location1",value:"${location1Name}\n inactive")
	sendEvent(name:"location2",value:"${location2Name}\n active")
   
   poll()
}
def location3Zip() {
    sendEvent(name: "city", value: "location3Zip")
    sendEvent(name:"Zip","value":location3Zip)
    sendEvent(name:"location2",value:"${location2Name}\n inactive")
    sendEvent(name:"location1",value:"${location1Name}\n inactive")
    sendEvent(name:"location3",value:"${location3Name}\n active")
  	poll()
}
// handle commands
def clearAttributeStates() {
		send(name: "observationTime",value:"", displayed: false)
		send(name: "observationEpoch",value:"", displayed: false)
        send(name: "weather", value:"", displayed: false)
		send(name: "tempString",value:"", displayed: false)
		send(name: "windString", value:"", displayed: false)
        send(name: "winddirection", value:"", displayed: false)
        send(name: "alertIcon", value:"", displayed: false)
        send(name: "wind_gust", value:"", displayed: false)
        send(name: "wind", value:"", displayed: false)
		send(name: "winddirection_deg", value:"", displayed: false)
        send(name: "windinfo", value:"", displayed: false)
		send(name: "pressureTrend", value:"", displayed: false)
   	 	send(name: "pressure", value:"", displayed: false) 
 		send(name: "dewPoint",value:"", displayed: false)
        send(name: "heatIndex",value:"", displayed: false)
        send(name: "windChill",value:"", displayed: false)
        send(name: "feelsLike", value:"", displayed: false)
        send(name: "visibility", value:"", displayed: false)
        send(name: "solarradiation", value:"", displayed: false)
        send(name: "uv_index", value:"", displayed: false)
		send(name: "precipLastHourString",value:"", displayed: false)
		send(name: "precipTodayString",value:"", displayed: false)
		send(name: "precipToday",value:"", displayed: false)
	    send(name: "precipLastHour", value:"", displayed: false)
		send(name: "fullLocation", value:"", displayed: false)
    	send(name: "city", value:"", displayed: false)
     	send(name: "state", value:"", displayed: false)
        send(name: "country", value:"", displayed: false)
        send(name: "Monday", value:"", displayed: false)
//	observation_location               
     	send(name: "latitude", value:"", displayed: false)
     	send(name: "longitude", value:"", displayed: false)
     	send(name: "elevation", value:"", displayed: false)       
	    send(name: "localSunrise", value:"", displayed: false)
        send(name: "localSunset", value:"", displayed: false)
        send(name: "timeZoneOffset", value:"", displayed: false)
        send(name: "water", value:"", displayed: false)
        send(name: "weatherIcon", value:"", displayed: false)
        send(name: "forecastIcon", value:"", displayed: false)
// Alerts Atrributes
        send(name: "alertMessage",value:"", displayed: false)
        send(name: "sunriseDate", value:"", displayed: false)
        send(name: "sunsetDate", value:"", displayed: false)
// Forecast attributes
        send(name: "Monday",value:"", displayed: false)
        send(name: "Wednesday",value:"", displayed: false)
        send(name: "Thursday",value:"", displayed: false)
        send(name: "Friday",value:"", displayed: false)
        send(name: "Saturday",value:"", displayed: false)
        send(name: "Sunday",value:"", displayed: false)
}

def poll() {
    log.debug "WUSTATION: Executing 'poll', location: ${location.name}"
    
    
    
    
    
    
   clearAttributeStates
// clear attributes
clearAttributeStates()
    // Current conditions
    def obs = get("conditions")?.current_observation
    if (obs) {
//   		log.debug "obs --> ${obs}"
        def now = new Date().format('M/d/yyyy h:mm a ',location.timeZone)
        sendEvent(name:"lastSTupdate", value: now, displayed: false)
        
        def weatherIcon = obs.icon_url.split("/")[-1].split("\\.")[0]
// new temp stuff
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
            
            	send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F", displayed: false)
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
                send(name: "pressure", value: "${obs.pressure_in} inches ", displayed: false)
                send(name: "visibility", value: "${obs.visibility_mi} mi", displayed: false)
                send(name: "precipToday", value: "${obs.precip_today_in} in", displayed: false)
               
               
              // send(name: "precipLastHour", value: "${obs.precip_1hr_in} in", displayed: false)
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)", displayed: false)
                send(name: "wind_gust", value: "${obs.wind_gust_mph} mph", displayed: false)
                send(name: "winddirection", value: "${obs.wind_dir}", displayed: false)
                send(name: "winddirection_deg", value: "${obs.wind_degrees}°", displayed: false)
                send(name: "wind", value: "${obs.wind_mph} mph", displayed: false)
                
                
                break;
            case "metric":
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
                send(name: "pressure", value: "${obs.pressure_mb} mbar ", displayed: false)
                send(name: "visibility", value: "${obs.visibility_km} km", displayed: false)
                send(name: "precipToday", value: "${obs.precip_today_metric} mm", displayed: false)
                send(name: "precipLastHour", value: "${obs.precip_1hr_metric} mm", displayed: false)
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_kph} kph\n(Gust: ${obs.wind_gust_kph} kph)", displayed: false)
                send(name: "wind_gust", value: "${obs.wind_gust_kph} kph", displayed: false)
                send(name: "winddirection", value: "${obs.wind_dir}", displayed: false)
                send(name: "winddirection_deg", value: "${obs.wind_degrees}°", displayed: false)
                send(name: "wind", value: "${obs.wind_kph} kph", displayed: false)
                
                
                break;
            default:
            	send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F", displayed: false)
            	send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F", displayed: false)
            	send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F", displayed: false)
 //           		send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "°F", displayed: false)
 //  		 		send(name: "heatIndex", value: obs.heat_index_f, displayed: false)
                send(name: "pressureTrend", value: "${obs.pressure_in} inches \n and (${pressure_trend_text})", displayed: false)
                send(name: "pressure", value: "${obs.pressure_in} inches ", displayed: false)
                send(name: "visibility", value: "${obs.visibility_mi} mi", displayed: false)
                send(name: "precipToday", value: "${obs.precip_today_in} in", displayed: false)
                send(name: "precipLastHour", value: "${obs.precip_1hr_in} in", displayed: false)
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)", displayed: false)
                send(name: "wind_gust", value: "${obs.wind_gust_mph} mph", displayed: false)
                send(name: "winddirection", value: "${obs.wind_dir}", displayed: false)
                send(name: "winddirection_deg", value: "${obs.wind_degrees}°", displayed: false)
                send(name: "wind", value: "${obs.wind_mph} mph", displayed: false)
                
            }
        } else {
            	send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F", displayed: false)
            	send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F", displayed: false)
            	send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F", displayed: false)
            	//send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "° F", displayed: false)
    			//send(name: "heatIndex", value: obs.heat_index_f, displayed: false)
                send(name: "pressureTrend", value: "${obs.pressure_mb} mbar (${pressure_trend_text})", displayed: false)
            	send(name: "pressure", value: "${obs.pressure_mb} mbar ", displayed: false)
                send(name: "visibility", value: "${obs.visibility_mi} mi", displayed: false)
                send(name: "precipToday", value: "${obs.precip_today_in} in", displayed: false)
                send(name: "precipLastHour", value: "${obs.precip_1hr_in} in", displayed: false)
             }      
				send(name: "tempString", value: obs.temperature_string, displayed: false)
 				send(name: "precipLastHourString", value: "${obs.precip_1hr_string}", displayed: false)
                send(name: "precipTodayString", value: "${obs.precip_today_string}", displayed: false)
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)", displayed: false)
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
       
        //send(name: "solarradiation", value: obs.solarradiation, displayed: false)
    
// Since precip_1hr_in is a string, we need to convert it to a decimal in order to compare it as a number.
        if (obs.precip_1hr_in.toFloat() > 0) {
            sendEvent( name: 'water', value: "true" , displayed: false)
            send(name: "precipLastHour", value: "${obs.precip_1hr_in} in", displayed: false)
        } else {
            sendEvent( name: 'water', value: "false" , displayed: false)
            send(name: "precipLastHour", value: "0.00 in", displayed: false)
        }
        if (obs.local_tz_offset != device.currentValue("timeZoneOffset")) {
            send(name: "timeZoneOffset", value: obs.local_tz_offset, isStateChange: true, displayed: false)
        }

        
        // Sunrise / sunset
        def astro = get("astronomy")?.moon_phase
     
       //working on this */
   switch (timeFormat) {
        case "12Hour" :
        send(name: "localSunset", value: Date.parse("HH:mm","${astro.sunset.hour}:${astro.sunset.minute}").format( 'h:mm a ' ), displayed: false)
     	send(name: "localSunrise", value: Date.parse("HH:mm","${astro.sunrise.hour}:${astro.sunrise.minute}").format( 'h:mm a' ), displayed: false)
       
        break;
		case "24Hour" :
        send(name: "localSunset", value: Date.parse("HH:mm","${astro.sunset.hour}:${astro.sunset.minute}").format( 'HH:mm ' ), displayed: false)
     	send(name: "localSunrise", value: Date.parse("HH:mm","${astro.sunrise.hour}:${astro.sunrise.minute}").format( 'HH:mm ' ), displayed: false)
        
		break;
        default :
        send(name: "localSunset", value: Date.parse("HH:mm","${astro.sunset.hour}:${astro.sunset.minute}").format( 'h:mm ' ), displayed: false)
     	send(name: "localSunrise", value: Date.parse("HH:mm","${astro.sunrise.hour}:${astro.sunrise.minute}").format( 'h:mm ' ), displayed: false)
   		
        }
        

        // Forecast
 def f = get("forecast10day")
        def f1= f?.forecast?.txt_forecast?.forecastday
        if (f1) {
            def icon = f1[0].icon_url.split("/")[-1].split("\\.")[0]
            def value = f1[0].pop as String // as String because of bug in determining state change of 0 numbers
            send(name: "percentPrecip", value: value, unit: "%")
            send(name: "forecastIcon", value: icon, displayed: false)
            switch(measUnits) {
                	case "imperial" :
             	      	send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext} \n ${f1[13].title}: ${f1[13].fcttext} ")
              	        send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext} \n ${f1[11].title}: ${f1[13].fcttext} ")
                     	send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext} \n ${f1[9].title}: ${f1[11].fcttext} ")
                     	send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext} \n ${f1[7].title}: ${f1[7].fcttext} ")
                    	send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext} \n ${f1[5].title}: ${f1[5].fcttext} ")
                       	send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext} \n ${f1[3].title}: ${f1[3].fcttext} ")
                        send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext} \n ${f1[1].title}: ${f1[1].fcttext} ")
                       	break;
                	case "metric" :
                       	send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext_metric} \n ${f1[13].title}: ${f1[13].fcttext_metric} ")
                	   	send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext_metric} \n ${f1[11].title}: ${f1[13].fcttext_metric} ")
                      	send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext_metric} \n ${f1[9].title}: ${f1[11].fcttext_metric} ")
                       	send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext_metric} \n ${f1[7].title}: ${f1[7].fcttext_metric} ")
                       	send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext_metric} \n ${f1[5].title}: ${f1[5].fcttext_metric} ")
                       	send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext_metric} \n ${f1[3].title}: ${f1[3].fcttext_metric} ")
                 		send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext_metric} \n ${f1[1].title}: ${f1[1].fcttext_metric} ")
                  break;
                    default:
                    	send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext} \n ${f1[13].title}: ${f1[13].fcttext} ")
              	        send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext} \n ${f1[11].title}: ${f1[13].fcttext} ")
                     	send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext} \n ${f1[9].title}: ${f1[11].fcttext} ")
                     	send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext} \n ${f1[7].title}: ${f1[7].fcttext} ")
                    	send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext} \n ${f1[5].title}: ${f1[5].fcttext} ")
                       	send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext} \n ${f1[3].title}: ${f1[3].fcttext} ")
                        send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext} \n ${f1[1].title}: ${f1[1].fcttext} ")
                  }
		}
        else {
            log.warn "Forecast not found"
        }
 // Alerts
        def alerts = get("alerts")?.alerts
        def alertType = "[${alerts?.type[0]}]"
        def newKeys = alerts?.collect{it.type + it.date_epoch} ?: []
        log.trace device.currentState("alertKeys")
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
                    //sendEvent(name:"alert", value:"[SPE]")
                    
                    newAlerts = true
                }
            }

            if (!newAlerts && device.currentValue("alert") != noneString) {
                send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true, displayed: false)
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
 // this is what i need to fix  
//    log.debug "device.currentState("alertKeys")"
    getWeatherFeature(feature,"${device.currentValue("Zip")}") 
}

private localDate(timeZone) {
    def df = new java.text.SimpleDateFormat("yyyy-MM-dd")
    df.setTimeZone(TimeZone.getTimeZone(timeZone))
    df.format(new Date())
}

private send(map) {
    log.debug "WUSTATION: event: $map"
    sendEvent(map)
    
}