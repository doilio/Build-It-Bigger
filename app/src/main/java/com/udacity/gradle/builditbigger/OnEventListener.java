package com.udacity.gradle.builditbigger;

/**
 * Interface used to decouple logic from the AsyncTask.
 * My tests were failing because after retrieving the result from onPostExecute,
 * Navigation was triggered from my Intent.
 *
 * With this interface each class reacts differently.
 * @param <T>
 */
public interface OnEventListener<T> {
    void onSuccess(T object);

    void onFailure(Exception e);
}
