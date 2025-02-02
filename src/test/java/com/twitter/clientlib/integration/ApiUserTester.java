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
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.model.GenericMultipleUsersLookupResponse;
import com.twitter.clientlib.model.InvalidRequestProblem;
import com.twitter.clientlib.model.MultiUserLookupResponse;
import com.twitter.clientlib.model.SingleUserLookupResponse;
import com.twitter.clientlib.model.UsersBlockingMutationResponse;
import com.twitter.clientlib.model.UsersFollowingCreateResponse;
import com.twitter.clientlib.model.UsersFollowingDeleteResponse;
import com.twitter.clientlib.model.UsersFollowingLookupResponse;
import com.twitter.clientlib.model.UsersIdBlockRequest;
import com.twitter.clientlib.model.UsersIdFollowRequest;
import com.twitter.clientlib.model.UsersIdMuteRequest;
import com.twitter.clientlib.model.UsersMutingMutationResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiUserTester extends ApiTester {

  private final String popularUsername = "TheRock";
  private final String usernameNotFound = "cprttfdgq";
  private final List<String> usersnames = Arrays.asList(popularUsername);
  private final List<String> usersnamesNotFounds = Arrays.asList(usernameNotFound);

  @BeforeAll
  public void init() {
    initApiInstance();
  }

  @Test
  public void findUserByIdTest() throws ApiException {
    SingleUserLookupResponse result = apiInstance.users().findUserById(userId, null, tweetFields,
        userFields);
    checkErrors(false, result.getErrors());
    checkUserData(result.getData());
    assertNull(result.getIncludes());
  }

  @Test
  public void findUserByIdErrorTest() throws ApiException {
    SingleUserLookupResponse result = apiInstance.users().findUserById(userNotExists, null,
        tweetFields,
        userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
  }

  @Test
  public void findUsersByIdTest() throws ApiException {
    MultiUserLookupResponse result = apiInstance.users().findUsersById(usersIds, null, tweetFields,
        userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData().get(0));
    assertNull(result.getIncludes());
  }

  @Test
  public void findUsersByIdErrorTest() throws ApiException {
    MultiUserLookupResponse result = apiInstance.users().findUsersById(usersIdsNotFound, null,
        tweetFields,
        userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error",
        "ids");
  }

  @Test
  public void findUserByUsernameTest() throws ApiException {
    SingleUserLookupResponse result = apiInstance.users().findUserByUsername(popularUsername, null,
        tweetFields, userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData());
    assertNull(result.getIncludes());
  }

  @Test
  public void findUserByUsernameFoundTest() throws ApiException {
    SingleUserLookupResponse result = apiInstance.users().findUserByUsername(usernameNotFound,
        null,
        tweetFields, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), usernameNotFound, "Not Found Error",
        "username");
  }

  @Test
  public void findUsersByUsernameTest() throws ApiException {
    MultiUserLookupResponse result = apiInstance.users().findUsersByUsername(usersnames, null,
        tweetFields,
        userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData().get(0));
    assertNull(result.getIncludes());
  }

  @Test
  public void findUsersByUsernameNotFoundTest() throws ApiException {
    MultiUserLookupResponse result = apiInstance.users().findUsersByUsername(usersnamesNotFounds,
        null,
        tweetFields, userFields);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), usernameNotFound, "Not Found Error",
        "usernames");
  }

  @Test
  public void findMyUserTest() throws ApiException {
    SingleUserLookupResponse result = apiInstance.users().findMyUser(null, tweetFields,
        userFields);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData());
    assertNull(result.getIncludes());
  }

  @Test
  public void usersIdFollowingTest() throws ApiException {
    UsersFollowingLookupResponse result = apiInstance.users().usersIdFollowing(popularUserId,
        maxResults,
        null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData().get(0));
    assertNull(result.getIncludes());
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void usersIdFollowingNotFoundTest() throws ApiException {
    UsersFollowingLookupResponse result = apiInstance.users().usersIdFollowing(userNotExists,
        maxResults,
        null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
    assertNull(result.getMeta());
  }

  @Test
  public void usersIdFollowersTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().usersIdFollowers(popularUserId,
        maxResults, null);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    checkUserData(result.getData().get(0));
    assertNull(result.getIncludes());
    assertNotNull(result.getMeta());
    assertTrue(result.getMeta().getResultCount() > 0);
  }

  @Test
  public void usersIdFollowersNotFoundTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().usersIdFollowers(userNotExists,
        maxResults, null);
    checkErrors(true, result.getErrors());
    assertNull(result.getData());
    checkResourceNotFoundProblem(result.getErrors().get(0), userNotExists, "Not Found Error", "id");
    assertNull(result.getMeta());
  }

  @Test
  public void usersIdFollowTest() throws ApiException {
    UsersIdFollowRequest request = new UsersIdFollowRequest();
    request.setTargetUserId(popularUserId);
    UsersFollowingCreateResponse result = apiInstance.users().usersIdFollow(request, userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getFollowing());
    assertFalse(result.getData().getPendingFollow());
  }

  @Test
  public void usersIdFollowFollowingNotFoundTest() throws ApiException {
    UsersIdFollowRequest request = new UsersIdFollowRequest();
    request.setTargetUserId(userNotExists);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdFollow(request, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot follow an account that is not active.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdFollowFollowerNotFoundTest() throws ApiException {
    UsersIdFollowRequest request = new UsersIdFollowRequest();
    request.setTargetUserId(popularUserId);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdFollow(request, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnfollowTest() throws ApiException {
    UsersFollowingDeleteResponse result = apiInstance.users().usersIdUnfollow(userId,
        popularUserId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getFollowing());
  }

  @Test
  public void usersIdUnfollowFollowingNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdUnfollow(userId, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot unfollow an account that is not active.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnfollowFollowerNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdUnfollow(userNotExists, popularUserId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `source_user_id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdBlockingTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().usersIdBlocking(userId,
        maxResults,
        null);
    checkErrors(false, result.getErrors());
    if (result.getData() != null) {
      checkUserData(result.getData().get(0));
      assertTrue(result.getMeta().getResultCount() > 0);
      assertNotNull(result.getIncludes());
    } else {
      assertEquals(0, (int) result.getMeta().getResultCount());
      assertNull(result.getIncludes());
    }
    assertNotNull(result.getMeta());
  }

  @Test
  public void usersIdBlockingNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdBlocking(userNotExists, maxResults, null);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdBlockTest() throws ApiException {
    UsersIdBlockRequest request = new UsersIdBlockRequest();
    request.setTargetUserId(popularUserId);
    UsersBlockingMutationResponse result = apiInstance.users().usersIdBlock(request, userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getBlocking());
  }

  @Test
  public void usersIdBlockBlockedNotFoundTest() throws ApiException {
    UsersIdBlockRequest request = new UsersIdBlockRequest();
    request.setTargetUserId(userNotExists);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdBlock(request, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot block an account that is not active.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdBlockBlockingNotFoundTest() throws ApiException {
    UsersIdBlockRequest request = new UsersIdBlockRequest();
    request.setTargetUserId(popularUserId);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdBlock(request, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnblockTest() throws ApiException {
    UsersIdBlockRequest request = new UsersIdBlockRequest();
    request.setTargetUserId(popularUserId);
    UsersBlockingMutationResponse result = apiInstance.users().usersIdUnblock(userId,
        popularUserId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getBlocking());
  }

  @Test
  public void usersIdUnblockBlockedNotFoundTest() throws ApiException {
    UsersIdBlockRequest request = new UsersIdBlockRequest();
    request.setTargetUserId(userNotExists);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdUnblock(userId, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot unblock an account that is not active.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnblockBlockingNotFoundTest() throws ApiException {
    UsersIdBlockRequest request = new UsersIdBlockRequest();
    request.setTargetUserId(popularUserId);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdUnblock(userNotExists, popularUserId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `source_user_id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdMutingTest() throws ApiException {
    GenericMultipleUsersLookupResponse result = apiInstance.users().usersIdMuting(userId,
        maxResults, null);
    checkErrors(false, result.getErrors());
    if (result.getData() != null) {
      checkUserData(result.getData().get(0));
      assertTrue(result.getMeta().getResultCount() > 0);
      assertNotNull(result.getIncludes());
    } else {
      assertEquals(0, (int) result.getMeta().getResultCount());
      assertNull(result.getIncludes());
    }
    assertNotNull(result.getMeta());
  }

  @Test
  public void usersIdMutingNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdMuting(userNotExists, maxResults, null);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdMuteTest() throws ApiException {
    UsersIdMuteRequest request = new UsersIdMuteRequest();
    request.setTargetUserId(popularUserId);
    UsersMutingMutationResponse result = apiInstance.users().usersIdMute(request, userId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertTrue(result.getData().getMuting());
  }

  @Test
  public void usersIdMuteMutedNotFoundTest() throws ApiException {
    UsersIdMuteRequest request = new UsersIdMuteRequest();
    request.setTargetUserId(userNotExists);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdMute(request, userId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot mute an account that is not active.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdMuteMutingNotFoundTest() throws ApiException {
    UsersIdMuteRequest request = new UsersIdMuteRequest();
    request.setTargetUserId(popularUserId);
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdMute(request, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnmuteTest() throws ApiException {
    UsersMutingMutationResponse result = apiInstance.users().usersIdUnmute(userId, popularUserId);
    checkErrors(false, result.getErrors());
    assertNotNull(result.getData());
    assertFalse(result.getData().getMuting());
  }

  @Test
  public void usersIdUnmuteMutedNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdUnmute(userId, userNotExists);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "You cannot unmute an account that is not active.",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }

  @Test
  public void usersIdUnmuteMutingNotFoundTest() throws ApiException {
    ApiException exception = assertThrows(ApiException.class, () -> {
      apiInstance.users().usersIdUnmute(userNotExists, popularUserId);
    });
    checkApiExceptionProblem(exception, InvalidRequestProblem.class,
        "The `source_user_id` query parameter value [" + userNotExists + "] must be the same as the authenticating user",
        "Invalid Request", "One or more parameters to your request was invalid.");
  }
}
