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


package com.twitter.clientlib.integration;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.DuplicateRuleProblem;
import com.twitter.clientlib.model.Expansions;
import com.twitter.clientlib.model.GenericProblem;
import com.twitter.clientlib.model.InvalidRequestProblem;
import com.twitter.clientlib.model.ModelList;
import com.twitter.clientlib.model.Problem;
import com.twitter.clientlib.model.ResourceNotFoundProblem;
import com.twitter.clientlib.model.Space;
import com.twitter.clientlib.model.Tweet;
import com.twitter.clientlib.model.User;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ApiTester {

  protected TwitterApi apiInstance;
  protected final Integer maxResults = 15;
  // Tweets
  protected final Set<String> tweetFields = new HashSet<>(
      Arrays.asList("author_id", "id", "created_at"));
  protected Set<String> expansions = new HashSet<>(Collections.singletonList("author_id"));
  protected String tweetId = "20";
  protected String tweetIdNotFound = "12119879112120";
  protected String tweetIdPopular = "1354143047324299264";
  // Users
  protected final Set<String> userFields = new HashSet<>(Collections.singletonList("username"));
  protected final String userId = System.getenv("YOUR_TWITTER_USER_ID");
  protected final String popularUserId = "250831586";
  protected final String userNotExists = "9999999999999";
  protected final List<String> usersIds = Arrays.asList(popularUserId);
  protected final List<String> usersIdsNotFound = Arrays.asList(userNotExists);

  protected void initApiInstance() {
          apiInstance = new TwitterApi();
          apiInstance.setTwitterCredentials(new TwitterCredentialsOAuth2(System.getenv("TWITTER_OAUTH2_CLIENT_ID"),
                  System.getenv("TWITTER_OAUTH2_CLIENT_SECRET"),
                  System.getenv("TWITTER_OAUTH2_ACCESS_TOKEN"),
                  System.getenv("TWITTER_OAUTH2_REFRESH_TOKEN")));
  }

  protected void initApiInstanceBearer() {
    apiInstance = new TwitterApi();
    apiInstance.setTwitterCredentials(new TwitterCredentialsBearer(System.getenv("TWITTER_BEARER_TOKEN")));
  }

  protected void checkApiExceptionProblem(
      ApiException e, Class problemType, String message, String title, String detail
  ) {
    Assert.assertTrue(
        e.getErrorObject().getProblem().getClass().getName().equals(problemType.getName()));
    InvalidRequestProblem problem = (InvalidRequestProblem) e.getErrorObject().getProblem();
    Assert.assertNotNull(problem.getErrors());
    Assert.assertNotNull(problem.getErrors().get(0));
    Assert.assertNotNull(problem.getErrors().get(0).getMessage());
    Assert.assertTrue(problem.getErrors().get(0).getMessage().contains(message));
    Assert.assertEquals(problem.getTitle(), title);
    Assert.assertEquals(problem.getDetail(), detail);
  }

  protected void checkErrors(boolean assertTrue, List<Problem> errors) {
    boolean hasErrors = errors != null && errors.size() > 0;
    if (assertTrue) {
      Assert.assertTrue(hasErrors);
    } else {
      Assert.assertFalse(hasErrors);
    }
  }

  protected void checkTweetData(Tweet tweet) {
    Assert.assertNotNull(tweet);
    Assert.assertNotNull(tweet.getText());
    Assert.assertNotNull(tweet.getAuthorId());
    Assert.assertNotNull(tweet.getCreatedAt());
  }

  protected void checkTweetIncludes(Expansions expansions) {
    Assert.assertNotNull(expansions);
    Assert.assertNotNull(expansions.getUsers());
    Assert.assertNotNull(expansions.getUsers().get(0));
    Assert.assertNotNull(expansions.getUsers().get(0).getUsername());
  }

  protected void checkUserData(User user) {
    Assert.assertNotNull(user);
    Assert.assertNotNull(user.getId());
    Assert.assertNotNull(user.getUsername());
    Assert.assertNotNull(user.getName());
  }

  protected void checkSpaceData(Space space) {
    Assert.assertNotNull(space);
    Assert.assertNotNull(space.getId());
    Assert.assertNotNull(space.getCreatedAt());
    Assert.assertNotNull(space.getCreatorId());
    Assert.assertNotNull(space.getTitle());
  }

  protected void checkListData(ModelList list) {
    Assert.assertNotNull(list);
    Assert.assertNotNull(list.getId());
    Assert.assertNotNull(list.getCreatedAt());
    Assert.assertNotNull(list.getDescription());
    Assert.assertNotNull(list.getOwnerId());
    Assert.assertNotNull(list.getFollowerCount());
  }

  protected void checkResourceNotFoundProblem(
      Problem problem, String value, String title, String parameter
  ) {
    Assert.assertTrue(problem instanceof ResourceNotFoundProblem);
    ResourceNotFoundProblem resourceNotFoundProblem = (ResourceNotFoundProblem) problem;
    Assert.assertTrue(resourceNotFoundProblem.getTitle().equals(title));
    Assert.assertEquals(parameter, resourceNotFoundProblem.getParameter());
    Assert.assertEquals(value, resourceNotFoundProblem.getValue());
  }

  protected void checkGenericProblem(Problem problem, String detail, String title, Integer status) {
    Assert.assertTrue(problem instanceof GenericProblem);
    GenericProblem genericProblem = (GenericProblem) problem;
    Assert.assertTrue(genericProblem.getTitle().equals(title));
    Assert.assertEquals(detail, genericProblem.getDetail());
    Assert.assertEquals(status, genericProblem.getStatus());
  }

  protected void checkInvalidRequestProblem(
      Problem problem, String detail, String title, String firstErrorMessage
  ) {
    Assert.assertTrue(problem instanceof InvalidRequestProblem);
    InvalidRequestProblem invalidRequestProblem = (InvalidRequestProblem) problem;
    Assert.assertTrue(invalidRequestProblem.getTitle().equals(title));
    Assert.assertEquals(detail, invalidRequestProblem.getDetail());
    Assert.assertEquals(firstErrorMessage, invalidRequestProblem.getErrors().get(0).getMessage());
  }

  protected void checkDuplicateRuleProblem(Problem problem, String detail, String value) {
    Assert.assertTrue(problem instanceof DuplicateRuleProblem);
    DuplicateRuleProblem duplicateProblem = (DuplicateRuleProblem) problem;
    Assert.assertTrue(duplicateProblem.getTitle().equals("DuplicateRule"));
//    Assert.assertEquals(detail, duplicateProblem.getDetail());
    Assert.assertEquals(value, duplicateProblem.getValue());
  }
}
