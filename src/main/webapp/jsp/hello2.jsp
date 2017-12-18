<html>
    <head>
        <script type="text/javascript">
            var SelectTool = function() {

            }

            SelectTool.prototype = {
                addOption: function(idSelect, text, value) {
                    var select = document.getElementById(idSelect);
                    var option = document.createElement("option");
                    if(value == null) {
                        value = text;
                    }
                    option.text = text;
                    option.value = value;
                    select.add(option);
                },

                removeOption: function(idSelect, index) {
                    document.getElementById(idSelect).remove(index);
                },

                clearOptions: function(idSelect) {
                    document.getElementById(idSelect).innerHTML = "";
                },

                getSelectedIndex: function(idSelect) {
                    return document.getElementById(idSelect).selectedIndex;
                },

                getValue: function(idSelect) {
                    var select = document.getElementById(idSelect);
                    var index = select.selectedIndex;
                    var options = select.options;
                    return options[index].value;
                },

                sayHello: function() {
                    console.log("Hello!!");
                }
            }

            //-------------------------------------------------------------
            //-------------------------------------------------------------

            var TopSelect = function(config) {

                this.selectedIndex = null;
                this.data = [];
                this.name = config.name;
                this.optionId = config.optionID;
                this.optionText = config.optionText;
                this.valueChangeListeners = [];

                this.notifyValueChangeListeners = function(ev) {
                    console.log("notifyValueChangeListeners()>>>>>");
                    console.log("event:" + ev);
                    var vcl = this.valueChangeListeners;
                    if(vcl == null) {
                        console.log("null");
                        return;
                    }
                    console.log("length:" + vcl.length);

                    for(var i = 0; i < vcl.length; i++) {
                        var method = vcl[i];
                        method(ev);
                    }
                };

                this.add = function(element) {
                    this.data.push(element);
                    this.refresh();
                };

                this.getData = function() {
                    return this.data;
                };

                this.refresh = function() {
                    this.clearOptions(this.name);
                    for(var i = 0; i < this.data.length; i++) {
                        var option = this.data[i];
                        this.addOption(this.name, option[this.optionText],option[this.optionId]);
                    }

                };

                this.clear = function() {
                    this.data = [];
                    this.refresh();
                };

                this.getValue = function() {
                    return this.getValue(this.name);
                };

                this.getSelectedOption = function() {
                    var selectedIndex = this.getSelectedIndex(this.name);
                    return this.data[selectedIndex];
                };

                this.setData = function(array) {
                    this.data = array;
                    this.refresh();
                };

                this.setValueChangeListener = function(callback) {
                    this.valueChangeListeners.push(callback);
                    var vcl = this.valueChangeListeners;
                    var ass = function(e) {
                        for(var i = 0; i < vcl.length; i++) {
                            var method = vcl[i];
                            method(ev);
                        }
                    }
                    document.getElementById(this.name).removeEventListener('change', ass);
                    document.getElementById(this.name).addEventListener('change', ass);
                };

                this.getValueChangeListeners = function() {
                    return this.valueChangeListeners;
                };


            }

            // inherit
            TopSelect.prototype = new SelectTool();

            // correct the constructor
            TopSelect.prototype.constructor = TopSelect;

            /*
            var select = new TopSelect({name:"mySelect", optionID:"ID", optionText:"Name"});
            var datos = [
                {ID:1, Name:"Julio"},
                {ID:2, Name:"Jorge"},
                {ID:3, Name:"Jesus"},
            ];
            select.setData(datos);
            select.setValueChangeListener(new function(ev){ console.log("1:" + ev)});
            */
            //
            //
            //document.getElementById(this.name).addEventListener('change', this.notifyValueChangeListeners);
        </script>
        <style>
               #map {
                height: 400px;
                width: 100%;
               }
        </style>
    </head>
    <body>
        hello2
        <br>
        <select id='mySelect'>
        </select>

        <h3>My Google Maps Demo</h3>
        <div id="map"></div>
        <script>
          function initMap() {
            var uluru = {lat: 20.9674019, lng: -89.6222634};
            var map = new google.maps.Map(document.getElementById('map'), {
              zoom: 4,
              center: uluru
            });
            var marker = new google.maps.Marker({
              position: uluru,
              map: map
            });
          }
        </script>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAdNu9u3SVQKqrXZXfmQB5oTwcj7XQX384&callback=initMap">
        </script>
    <body>
</html>
