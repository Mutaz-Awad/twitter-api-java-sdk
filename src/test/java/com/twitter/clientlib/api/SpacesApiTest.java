/*
Copyright 2020 Twitter, Inc.
SPDX-License-Identifier: Apache-2.0

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
https://openapi-generator.tech
Do not edit the class manually.
*/


package com.twitter.clientlib.api;

import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.Error;
import com.twitter.clientlib.model.MultiSpaceLookupResponse;
import com.twitter.clientlib.model.MultiTweetLookupResponse;
import com.twitter.clientlib.model.MultiUserLookupResponse;
import com.twitter.clientlib.model.Problem;
import java.util.Set;
import com.twitter.clientlib.model.SingleSpaceLookupResponse;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.InputStream;

/**
 * API tests for SpacesApi
 */
@Ignore
public class SpacesApiTest {

    private final TwitterApi apiInstance = new TwitterApi();
    // TODO set credentials
    
    /**
     * Space lookup by Space ID
     *
     * Returns a variety of information about the Space specified by the requested ID
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findSpaceByIdTest() throws ApiException {
        String id = null;
        Set<String> spaceFields = null;
        Set<String> expansions = null;
                SingleSpaceLookupResponse response = apiInstance.spaces().findSpaceById(id, spaceFields, expansions);
        // TODO: test validations
    }
    
    /**
     * Space lookup by their creators
     *
     * Returns a variety of information about the Spaces created by the provided User IDs
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findSpacesByCreatorIdsTest() throws ApiException {
        List<String> userIds = null;
        Set<String> spaceFields = null;
        Set<String> expansions = null;
                MultiSpaceLookupResponse response = apiInstance.spaces().findSpacesByCreatorIds(userIds, spaceFields, expansions);
        // TODO: test validations
    }
    
    /**
     * Space lookup up Space IDs
     *
     * Returns a variety of information about the Spaces specified by the requested IDs
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findSpacesByIdsTest() throws ApiException {
        List<String> ids = null;
        Set<String> spaceFields = null;
        Set<String> expansions = null;
                MultiSpaceLookupResponse response = apiInstance.spaces().findSpacesByIds(ids, spaceFields, expansions);
        // TODO: test validations
    }
    
    /**
     * Search for Spaces
     *
     * Returns Spaces that match the provided query.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void searchSpacesTest() throws ApiException {
        String query = null;
        String state = null;
        Integer maxResults = null;
        Set<String> spaceFields = null;
        Set<String> expansions = null;
                MultiSpaceLookupResponse response = apiInstance.spaces().searchSpaces(query, state, maxResults, spaceFields, expansions);
        // TODO: test validations
    }
    
    /**
     * Retrieve the list of users who purchased a ticket to the given space
     *
     * Retrieves the list of users who purchased a ticket to the given space
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spaceBuyersTest() throws ApiException {
        String id = null;
        Set<String> userFields = null;
                MultiUserLookupResponse response = apiInstance.spaces().spaceBuyers(id, userFields);
        // TODO: test validations
    }
    
    /**
     * Retrieve tweets from a Space
     *
     * Retrieves tweets shared in the specified space
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void spaceTweetsTest() throws ApiException {
        Integer maxResults = null;
        String id = null;
        Set<String> tweetFields = null;
                MultiTweetLookupResponse response = apiInstance.spaces().spaceTweets(maxResults, id, tweetFields);
        // TODO: test validations
    }
    
}
