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
*/
metadata {
    definition (name: "My Weather Device 1.0", namespace: "AGOPACK2", author: "Gopack2") {
        capability "Illuminance Measurement"
        capability "Temperature Measurement"
        capability "Relative Humidity Measurement"
        capability "Sensor"
        capability "Polling"
// Current Conditions
		attribute "observationTime","string"
		attribute "observationEpoch","string"
        attribute "weather", "string"
		attribute "tempString","string"
		attribute "windString", "string"
        attribute "winddirection", "string"
//        attribute "wind_degrees", "string"
        attribute "wind_gust", "string"
        attribute "wind", "string"
		attribute "winddirection_deg", "string"
        attribute "windinfo", "string"
		attribute "pressureTrend", "string"
   	 	attribute "pressure", "string" 
 		attribute "dewPoint","string"
        attribute "heatIndex","string"
        attribute "windChill","string"
        attribute "feelsLike", "string"
        attribute "visibility", "string"
        attribute "solarradiation", "string"
        attribute "uv_index", "string"
		attribute "precipLastHourString","string"
		attribute "precipTodayString","string"
		attribute "precipToday","string"
	    attribute "precipLastHour", "string"
		attribute "fullLocation", "string"
    	attribute "city", "string"
     	attribute "state", "string"
        attribute "country", "string"
        attribute "Zip","string"

//	observation_location               
     	attribute "latitude", "string"
     	attribute "longitude", "string"
     	attribute "elevation", "string"       
	    attribute "localSunrise", "string"
        attribute "localSunset", "string"
        attribute "timeZoneOffset", "string"
        attribute "water", "string"
        attribute "weatherIcon", "string"
        attribute "forecastIcon", "string"
       
// Alerts Atrributes
        attribute "alert", "string"
        attribute "alertKeys", "string"
        attribute "alertMessage","string"
        attribute "sunriseDate", "string"
        attribute "sunsetDate", "string"


// Forecast Attributes 
     	attribute "ForecastMonday", "string"
        attribute "ForecastTuesday","string"
        attribute "ForecastWednesday","string"
        attribute "ForecastThursday","string"
       	attribute "ForecastFriday","string"
        attribute "ForecastSaturday","string"
   		attribute "ForecastSunday", "string"     
        
        
        command "location1Zip"
      	command "location3Zip"
      	command "location2Zip"
       	command "refresh"
	//	command "clear"
        
    }

    preferences {
        //input "zipCode", "text", title: "Zip Code (optional)", required: false
        input name: "location1Zip", type: "number", title: "Zip Code", description: "Enter a Zipcode For Location", required: true
        input name: "location1Name", type: "string", title: "Name Of Location", description: "Enter a Name For Your Zipcode", required: true
 		input name: "location2Zip", type: "number", title: "Zip Code", description: "Enter a Zipcode For Location", required: true
        input name: "location2Name", type: "string", title: "Name Of Location", description: "Enter a Name For Your Zipcode", required: true
		input name: "location3Zip", type: "number", title: "Zip Code", description: "Enter a Zipcode For Location", required: true
        input name: "location3Name", type: "string", title: "Name Of Location", description: "Enter a Name For Your Zipcode", required: true
        input ("measUnits", "enum", title: "Measuerment units", required: false, 
			options: [
		        "imperial":"Imperial",
		        "metric":"Metric"
            ])
    	input ("timeFormat", "enum", title: "Time Format", required: false, 
			options: [
		        "12Hour":"12 Hour Format, i.e. 01:00 PM",
		        "24Hour":"24 Hour Format, i.e. 13:00 PM"
            ])
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
        valueTile("alert", "device.alert", inactiveLabel: false, width: 5, height: 1, decoration: "flat", wordWrap: true) {
            state "default", label:'Weather Alerts:\n ${currentValue}'
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
  //      standardTile("location", "device.city", inactiveLabel: true, width: 2, height: 3) {
	//		state("location1Zip", label:"location1Zip", icon:"http://cdn.device-icons.smartthings.com/Outdoor/outdoor4-icn@2x.png", backgroundColor:"#FC030F")
	//		state("location3Zip", label:"location3Zip", value: ZipCode, icon:"st.Food & Dining.dining12",backgroundColor:"#07F7D7")
	//		state("location2Zip", label:"location2Zip", icon:"st.Food & Dining.dining13", backgroundColor:"#5F07F7")
	//	}
		standardTile("location1Zip", "device.location1Zip",width: 2, height: 2, inactiveLabel: false, decoration: "flat") {
			state "active", label: "location1Zip", action:"location1Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Lighthouse%20Active.png?raw=true​"
            state "inactive", label: "location1Zip", action:"location1Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Lighthouse%20Inactive.png?raw=true"
	    }
		standardTile("location2Zip", "device.location2Zip", width: 2, height: 2,inactiveLabel: false,decoration: "flat" ) {
			state "active", label:"location2Zip", action:"location2Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Cabin%20Active.png?raw=true"
			state "inactive", label:"location2Zip", action:"location2Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Cabin%20Inactive.png?raw=true"
            }        
		standardTile("location3Zip", "device.location3Zip", width: 2, height: 2,inactiveLabel: false,decoration: "flat") {
			state "active", label:"location3Zip", action:"location3Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Arizona%20Active.png?raw=true"
			state "inactive", label:"location3Zip", action:"location3Zip", icon:"https://github.com/Gopack2/A-Better-Weather/blob/master/Arizona%20Inactiuve.png?raw=true"
        }   
        valueTile("forecast", "device.Forecast0", width: 6, height: 6, canChangeBackground: true) {
 		state "longitude", label: '${currentValue}'
 		}
        
    main(["temperature2"])
	      details(["alert", "location1Zip","location2Zip","location3Zip","temperature", "feelslike","weatherIcon","weather"
        	, "humidity" , "dewpoint", "windinfo", "pressure", "solarradiation", "uv_index", 
          "light", "visibility", "city", "rise", "set", "lastSTupdate", "percentPrecip", "PrecipToday",
          "PrecipLastHour", "water", "refresh"])
//		main (["location"])
//			details(["location1","location1Zip","location2Zip","location3Zip","alert","refresh"])
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
    
    sendEvent(name: "city", value: "location1Zip")
    sendEvent(name:"Zip","value":location1Zip)
    sendEvent(name:"location3Zip",value:"inactive")
 	sendEvent(name:"location2Zip",value:"inactive")
	sendEvent(name:"location1Zip",value:"active")	
   
    poll()
}
def location2Zip() {
    sendEvent(name: "city", value:"location2Zip")
    sendEvent(name:"Zip","value":location2Zip)
    sendEvent(name:"location3Zip",value:"inactive")
 	sendEvent(name:"location1Zip",value:"inactive")
	sendEvent(name:"location2Zip",value:"active")
   	
    poll()
}
def location3Zip() {
    sendEvent(name: "city", value: "Surprise")
    sendEvent(name:"Zip","value":location3Zip)
    sendEvent(name:"location2Zip",value:"inactive")
    sendEvent(name:"location1Zip",value:"inactive")
    sendEvent(name:"location3Zip",value:"active")
  	poll()
}


// handle commands
def clearAttributeStates() {
		send(name: "observationTime",value:"")
		send(name: "observationEpoch",value:"")
        send(name: "weather", value:"")
		send(name: "tempString",value:"")
		send(name: "windString", value:"")
        send(name: "winddirection", value:"")
  //      send(name: "wind_degrees", value:"")
        send(name: "wind_gust", value:"")
        send(name: "wind", value:"")
		send(name: "winddirection_deg", value:"")
        send(name: "windinfo", value:"")
		send(name: "pressureTrend", value:"")
   	 	send(name: "pressure", value:"") 
 		send(name: "dewPoint",value:"")
        send(name: "heatIndex",value:"")
        send(name: "windChill",value:"")
        send(name: "feelsLike", value:"")
        send(name: "visibility", value:"")
        send(name: "solarradiation", value:"")
        send(name: "uv_index", value:"")
		send(name: "precipLastHourString",value:"")
		send(name: "precipTodayString",value:"")
		send(name: "precipToday",value:"")
	    send(name: "precipLastHour", value:"")
		send(name: "fullLocation", value:"")
    	send(name: "city", value:"")
     	send(name: "state", value:"")
        send(name: "country", value:"")
        send(name: "Monday", value:"")
//       send(name: "Zip",value:"")

//	observation_location               
     	send(name: "latitude", value:"")
     	send(name: "longitude", value:"")
     	send(name: "elevation", value:"")       
	    send(name: "localSunrise", value:"")
        send(name: "localSunset", value:"")
        send(name: "timeZoneOffset", value:"")
        send(name: "water", value:"")
        send(name: "weatherIcon", value:"")
        send(name: "forecastIcon", value:"")
       
// Alerts Atrributes
        //send(name: "alert", value:"")
        //send(name: "alertKeys", value:"[]")
        send(name: "alertMessage",value:"")
        send(name: "sunriseDate", value:"")
        send(name: "sunsetDate", value:"")


// Forecast attributes
        send(name: "Monday",value:"")
        send(name: "Wednesday",value:"")
        send(name: "Thursday",value:"")
        send(name: "Friday",value:"")
        send(name: "Saturday",value:"")
        send(name: "Sunday",value:"")
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
        def now = new Date().format('M/d/yyyy HH:mm a ',location.timeZone)
        sendEvent(name:"lastSTupdate", value: now)
        
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
            	send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F")
            	send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F")
            	send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F")
          		if ( obs.windchill_f == "NA") (
          			send(name: "windChill", value: "--"))
          		else ( 
                	send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "° F")
          		)
          		          		 		 
                if ( obs.heat_index_f == "NA") (
                	send(name: "heatIndex", value: "--"))
                else (send(name: "heatIndex", value: obs.heat_index_f)
                )
                send(name: "pressureTrend", value: "${obs.pressure_in} inches \n and (${pressure_trend_text})")
                send(name: "pressure", value: "${obs.pressure_in} inches ")
                send(name: "visibility", value: "${obs.visibility_mi} mi")
                send(name: "precipToday", value: "${obs.precip_today_in} in")
               
               
              // send(name: "precipLastHour", value: "${obs.precip_1hr_in} in")
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)")
                send(name: "wind_gust", value: "${obs.wind_gust_mph} mph")
                send(name: "winddirection", value: "${obs.wind_dir}")
                send(name: "winddirection_deg", value: "${obs.wind_degrees}°")
                send(name: "wind", value: "${obs.wind_mph} mph")
                
                
                break;
            case "metric":
                send(name: "temperature", value: Math.round(obs.temp_c), unit: "° C")
            	send(name: "feelsLike", value: Math.round(obs.feelslike_c as Double), unit: "° C")
            	send(name: "dewPoint", value: Math.round(obs.dewpoint_c as Double), unit: "° C")
            	if ( obs.windchill_c== "NA") (
          			send(name: "windChill", value: "--"))
          		else ( send(name: "windChill", value: Math.round(obs.windchill_c as Double), unit: "°C")
          		)
   		 		if ( obs.heat_index_c == "NA") (
                	send(name: "heatIndex", value: "--"))
                else (send(name: "heatIndex", value: obs.heat_index_c)
                )
                send(name: "pressureTrend", value: "${obs.pressure_mb} mbar (${pressure_trend_text})")
                send(name: "pressure", value: "${obs.pressure_mb} mbar ")
                send(name: "visibility", value: "${obs.visibility_km} km")
                send(name: "precipToday", value: "${obs.precip_today_metric} mm")
                send(name: "precipLastHour", value: "${obs.precip_1hr_metric} mm")
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_kph} kph\n(Gust: ${obs.wind_gust_kph} kph)")
                send(name: "wind_gust", value: "${obs.wind_gust_kph} kph")
                send(name: "winddirection", value: "${obs.wind_dir}")
                send(name: "winddirection_deg", value: "${obs.wind_degrees}°")
                send(name: "wind", value: "${obs.wind_kph} kph")
                
                
                break;
            default:
            	send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F")
            	send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F")
            	send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F")
 //           		send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "°F")
 //  		 		send(name: "heatIndex", value: obs.heat_index_f)
                send(name: "pressureTrend", value: "${obs.pressure_in} inches \n and (${pressure_trend_text})")
                send(name: "pressure", value: "${obs.pressure_in} inches ")
                send(name: "visibility", value: "${obs.visibility_mi} mi")
                send(name: "precipToday", value: "${obs.precip_today_in} in")
                send(name: "precipLastHour", value: "${obs.precip_1hr_in} in")
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)")
                send(name: "wind_gust", value: "${obs.wind_gust_mph} mph")
                send(name: "winddirection", value: "${obs.wind_dir}")
                send(name: "winddirection_deg", value: "${obs.wind_degrees}°")
                send(name: "wind", value: "${obs.wind_mph} mph")
                
            }
        } else {
            	send(name: "temperature", value: Math.round(obs.temp_f), unit: "° F")
            	send(name: "feelsLike", value: Math.round(obs.feelslike_f as Double), unit: "° F")
            	send(name: "dewPoint", value: Math.round(obs.dewpoint_f as Double), unit: "° F")
            	//send(name: "windChill", value: Math.round(obs.windchill_f as Double), unit: "° F")
    			//send(name: "heatIndex", value: obs.heat_index_f)
                send(name: "pressureTrend", value: "${obs.pressure_mb} mbar (${pressure_trend_text})")
            	send(name: "pressure", value: "${obs.pressure_mb} mbar ")
                send(name: "visibility", value: "${obs.visibility_mi} mi")
                send(name: "precipToday", value: "${obs.precip_today_in} in")
                send(name: "precipLastHour", value: "${obs.precip_1hr_in} in")
             }      
				send(name: "tempString", value: obs.temperature_string)
 				send(name: "precipLastHourString", value: "${obs.precip_1hr_string}")
                send(name: "precipTodayString", value: "${obs.precip_today_string}")
                send(name: "windinfo", value: "${obs.wind_dir} (${obs.wind_degrees}°) at ${obs.wind_mph} mph\n(Gust: ${obs.wind_gust_mph} mph)")
 			 	send(name: "windString", value: "${obs.wind_string}")
                
                
		send(name: "fullLocation", value: obs.display_location.full)
        send(name: "state", value: obs.display_location.state)
        send(name: "city", value: obs.display_location.city)
        send(name: "country", value: obs.display_location.country)
        send(name: "humidity", value: obs.relative_humidity[0..-2] as Integer, unit: "%")
        send(name: "weather", value: obs.weather)
        send(name: "weatherIcon", value: weatherIcon, displayed: false)
        send(name: "uv_index", value: obs.UV)
        send(name: "latitude", value: obs.observation_location.latitude)
        send(name: "longitude", value: obs.observation_location.longitude)
        send(name: "elevation", value: obs.observation_location.elevation)
        send(name: "observationTime", value: obs.observation_time)
        send(name: "observationEpoch", value: obs.observation_epoch)
       
        //send(name: "solarradiation", value: obs.solarradiation)
  
  
  
// add more forecast attributes here  

        
        
// Since precip_1hr_in is a string, we need to convert it to a decimal in order to compare it as a number.
        if (obs.precip_1hr_in.toFloat() > 0) {
            sendEvent( name: 'water', value: "true" )
            send(name: "precipLastHour", value: "${obs.precip_1hr_in} in")
        } else {
            sendEvent( name: 'water', value: "false" )
            send(name: "precipLastHour", value: "0.00 in")
        }
        if (obs.local_tz_offset != device.currentValue("timeZoneOffset")) {
            send(name: "timeZoneOffset", value: obs.local_tz_offset, isStateChange: true)
        }

        
        // Sunrise / sunset
        def astro = get("astronomy")?.moon_phase
       // def today = localDate("GMT${obs.local_tz_offset}")
      //  def ltf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm ")
      //  ltf.setTimeZone(TimeZone.getTimeZone("GMT${obs.local_tz_offset}"))
     //   def utf = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
     //   utf.setTimeZone(TimeZone.getTimeZone("GMT"))

        //def sunriseDate = ltf.parse("${today} ${a.sunrise.hour}:${a.sunrise.minute}")
        //def sunsetDate = ltf.parse("${today} ${a.sunset.hour}:${a.sunset.minute}")

       // def tf = new java.text.SimpleDateFormat("HH:mm")
      //  tf.setTimeZone(TimeZone.getTimeZone("GMT${obs.local_tz_offset}"))
       // def localSunrise = "${tf.format(sunriseDate)}"
       // def localSunset = "${tf.format(sunsetDate)}"
       // def setHour = ${astro.sunset.hour}
        send(name: "localSunset", value: "${astro.sunset.hour}"-12)
        
        
      //  send(name: "localSunrise", value: localSunrise, descriptionText: "Sunrise today is at $localSunrise")
        //send(name: "localSunset", value: localSunset, descriptionText: "Sunset today at is $localSunset")
        
        
        

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
                    	send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext} \n ${f1[1].title}: ${f1[1].fcttext} ")
                        send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext} \n ${f1[3].title}: ${f1[3].fcttext} ")
                        send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext} \n ${f1[5].title}: ${f1[5].fcttext} ")
                        send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext} \n ${f1[7].title}: ${f1[7].fcttext} ")
                     	send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext} \n ${f1[9].title}: ${f1[11].fcttext} ")
                     	send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext} \n ${f1[11].title}: ${f1[13].fcttext} ")
                     	send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext} \n ${f1[13].title}: ${f1[13].fcttext} ")
                       	break;
                	case "metric" :
                    	send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext_metric} \n ${f1[1].title}: ${f1[1].fcttext_metric} ")
                        send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext_metric} \n ${f1[3].title}: ${f1[3].fcttext_metric} ")
                        send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext_metric} \n ${f1[5].title}: ${f1[5].fcttext_metric} ")
                        send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext_metric} \n ${f1[7].title}: ${f1[7].fcttext_metric} ")
                     	send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext_metric} \n ${f1[9].title}: ${f1[11].fcttext_metric} ")
                     	send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext_metric} \n ${f1[11].title}: ${f1[13].fcttext_metric} ")
                     	send(name: "Forecast${f1[12].title}",value: "${f1[12].title}: ${f1[12].fcttext_metric} \n ${f1[13].title}: ${f1[13].fcttext_metric} ")
                	break;
                    default:
                    	send(name: "Forecast${f1[0].title}",value: "${f1[0].title}: ${f1[0].fcttext} \n ${f1[1].title}: ${f1[1].fcttext} ")
                        send(name: "Forecast${f1[2].title}",value: "${f1[2].title}: ${f1[2].fcttext} \n ${f1[3].title}: ${f1[3].fcttext} ")
                        send(name: "Forecast${f1[4].title}",value: "${f1[4].title}: ${f1[4].fcttext} \n ${f1[5].title}: ${f1[5].fcttext} ")
                        send(name: "Forecast${f1[6].title}",value: "${f1[6].title}: ${f1[6].fcttext} \n ${f1[7].title}: ${f1[7].fcttext} ")
                     	send(name: "Forecast${f1[8].title}",value: "${f1[8].title}: ${f1[8].fcttext} \n ${f1[9].title}: ${f1[11].fcttext} ")
                     	send(name: "Forecast${f1[10].title}",value: "${f1[10].title}: ${f1[10].fcttext} \n ${f1[11].title}: ${f1[13].fcttext} ")
                     	send(name: "Forecast${f1[12].title}Forecast",value: "${f1[12].title}: ${f1[12].fcttext} \n ${f1[13].title}: ${f1[13].fcttext} ")
                  }
		}
        else {
            log.warn "Forecast not found"
        }
 // Alerts
        def alerts = get("alerts")?.alerts
        
        
        def newKeys = alerts?.collect{it.type + it.date_epoch} ?: []
        //log.debug "WUSTATION: newKeys = $newKeys"
        log.trace device.currentState("alertKeys")
        def oldKeys = device.currentState("alertKeys")?.jsonValue
        //log.debug "WUSTATION: oldKeys = $oldKeys"

        def noneString = "there are no current weather alerts"
        if (!newKeys && oldKeys == null) {
            send(name: "alertKeys", value: newKeys.encodeAsJSON(), displayed: false)
            send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true)
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
                    send(name: "alert", value: pad(alert.description), descriptionText: msg, isStateChange: true)
                    send(name: "alertMessage",value: "${alert.message}")
                    newAlerts = true
                }
            }

            if (!newAlerts && device.currentValue("alert") != noneString) {
                send(name: "alert", value: noneString, descriptionText: "${device.displayName} has no current weather alerts", isStateChange: true)
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
    //log.debug "WUSTATION: event: $map"
    sendEvent(map)
}