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


package com.twitter.clientlib.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.twitter.clientlib.model.ClientDisconnectedProblem;
import com.twitter.clientlib.model.ClientForbiddenProblem;
import com.twitter.clientlib.model.ConflictProblem;
import com.twitter.clientlib.model.ConnectionExceptionProblem;
import com.twitter.clientlib.model.DisallowedResourceProblem;
import com.twitter.clientlib.model.DuplicateRuleProblem;
import com.twitter.clientlib.model.DuplicateRuleProblemAllOf;
import com.twitter.clientlib.model.FieldUnauthorizedProblem;
import com.twitter.clientlib.model.GenericProblem;
import com.twitter.clientlib.model.InvalidRequestProblem;
import com.twitter.clientlib.model.InvalidRuleProblem;
import com.twitter.clientlib.model.NonCompliantRulesProblem;
import com.twitter.clientlib.model.OperationalDisconnectProblem;
import com.twitter.clientlib.model.Problem;
import com.twitter.clientlib.model.ResourceNotFoundProblem;
import com.twitter.clientlib.model.ResourceUnauthorizedProblem;
import com.twitter.clientlib.model.ResourceUnavailableProblem;
import com.twitter.clientlib.model.RulesCapProblem;
import com.twitter.clientlib.model.UnsupportedAuthenticationProblem;
import com.twitter.clientlib.model.UsageCapExceededProblem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.twitter.clientlib.JSON;

/**
 * The rule you have submitted is a duplicate.
 */
@ApiModel(description = "The rule you have submitted is a duplicate.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DuplicateRuleProblem extends Problem {
  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public DuplicateRuleProblem() { 
    this.type = this.getClass().getSimpleName();
  }

  public DuplicateRuleProblem value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public DuplicateRuleProblem id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DuplicateRuleProblem duplicateRuleProblem = (DuplicateRuleProblem) o;
    return Objects.equals(this.value, duplicateRuleProblem.value) &&
        Objects.equals(this.id, duplicateRuleProblem.id) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, id, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DuplicateRuleProblem {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("type");
    openapiFields.add("title");
    openapiFields.add("detail");
    openapiFields.add("status");
    openapiFields.add("value");
    openapiFields.add("id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("type");
    openapiRequiredFields.add("title");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to DuplicateRuleProblem
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (DuplicateRuleProblem.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has reuqired fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in DuplicateRuleProblem is not found in the empty JSON string", DuplicateRuleProblem.openapiRequiredFields.toString()));
        }
      }
      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!DuplicateRuleProblem.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DuplicateRuleProblem` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : DuplicateRuleProblem.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DuplicateRuleProblem.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DuplicateRuleProblem' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DuplicateRuleProblem> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DuplicateRuleProblem.class));

       return (TypeAdapter<T>) new TypeAdapter<DuplicateRuleProblem>() {
           @Override
           public void write(JsonWriter out, DuplicateRuleProblem value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DuplicateRuleProblem read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DuplicateRuleProblem given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DuplicateRuleProblem
  * @throws IOException if the JSON string is invalid with respect to DuplicateRuleProblem
  */
  public static DuplicateRuleProblem fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DuplicateRuleProblem.class);
  }

 /**
  * Convert an instance of DuplicateRuleProblem to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

