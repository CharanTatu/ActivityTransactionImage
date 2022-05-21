// Generated by view binder compiler. Do not edit!
package com.example.android.activityscenetransitionbasic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.android.activityscenetransitionbasic.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class GridItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageviewItem;

  @NonNull
  public final TextView textviewName;

  private GridItemBinding(@NonNull LinearLayout rootView, @NonNull ImageView imageviewItem,
      @NonNull TextView textviewName) {
    this.rootView = rootView;
    this.imageviewItem = imageviewItem;
    this.textviewName = textviewName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static GridItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static GridItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.grid_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static GridItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageview_item;
      ImageView imageviewItem = rootView.findViewById(id);
      if (imageviewItem == null) {
        break missingId;
      }

      id = R.id.textview_name;
      TextView textviewName = rootView.findViewById(id);
      if (textviewName == null) {
        break missingId;
      }

      return new GridItemBinding((LinearLayout) rootView, imageviewItem, textviewName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}