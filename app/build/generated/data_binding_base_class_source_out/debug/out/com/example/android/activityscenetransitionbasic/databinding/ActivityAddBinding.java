// Generated by view binder compiler. Do not edit!
package com.example.android.activityscenetransitionbasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.android.activityscenetransitionbasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText password;

  @NonNull
  public final Button submit;

  @NonNull
  public final EditText username;

  private ActivityAddBinding(@NonNull LinearLayout rootView, @NonNull EditText password,
      @NonNull Button submit, @NonNull EditText username) {
    this.rootView = rootView;
    this.password = password;
    this.submit = submit;
    this.username = username;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.password;
      EditText password = rootView.findViewById(id);
      if (password == null) {
        break missingId;
      }

      id = R.id.submit;
      Button submit = rootView.findViewById(id);
      if (submit == null) {
        break missingId;
      }

      id = R.id.username;
      EditText username = rootView.findViewById(id);
      if (username == null) {
        break missingId;
      }

      return new ActivityAddBinding((LinearLayout) rootView, password, submit, username);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}