// Generated by view binder compiler. Do not edit!
package com.example.android.activityscenetransitionbasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.android.activityscenetransitionbasic.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class GridBinding implements ViewBinding {
  @NonNull
  private final ListView rootView;

  @NonNull
  public final ListView grid;

  private GridBinding(@NonNull ListView rootView, @NonNull ListView grid) {
    this.rootView = rootView;
    this.grid = grid;
  }

  @Override
  @NonNull
  public ListView getRoot() {
    return rootView;
  }

  @NonNull
  public static GridBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static GridBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.grid, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static GridBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    ListView grid = (ListView) rootView;

    return new GridBinding((ListView) rootView, grid);
  }
}