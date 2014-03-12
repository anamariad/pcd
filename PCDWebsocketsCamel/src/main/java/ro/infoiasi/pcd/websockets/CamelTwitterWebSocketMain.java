/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.infoiasi.pcd.websockets;

import org.apache.camel.main.Main;

/**
 * A main to start this example.
 */
public final class CamelTwitterWebSocketMain {

    private static final String consumerKey = "N45d7sPCyVyV1ohKfY7NkA";
    private static final String consumerSecret = "xpzFA15wp2ipkP7RJxTFMjsTfrPvxUQRXMYbqrE7V0";
    private static final String accessToken = "2384266112-S2SpzGvEHcda0nOwWeheqbUNs8uRzibIfKr8O63";
    private static final String accessTokenSecret = "o8w9EYzChMXzt6QKmA18O6Y900XvZwLEALY7lPDP8OubG";

    private CamelTwitterWebSocketMain() {

    }

    public static void main(String[] args) throws Exception {

        // create a new Camel Main so we can easily start Camel
        Main main = new Main();

        // enable hangup support which mean we detect when the JVM terminates, and stop Camel gracefully
        main.enableHangupSupport();

        TwitterWebSocketRoute route = new TwitterWebSocketRoute();

        // setup twitter application authentication
        route.setAccessToken(accessToken);
        route.setAccessTokenSecret(accessTokenSecret);
        route.setConsumerKey(consumerKey);
        route.setConsumerSecret(consumerSecret);

        // poll for school, every 2nd second
        route.setSearchTerm("school");
        route.setDelay(2);

        // web socket on port 9090
        route.setPort(9090);

        // add our routes to Camel
        main.addRouteBuilder(route);

        // and run, which keeps blocking until we terminate the JVM (or stop CamelContext)
        main.run();
    }

}