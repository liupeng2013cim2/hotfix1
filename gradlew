<?xml version="1.0" encoding="utf-8"?>
<!--
  ~ Copyright (C) 2016 The Android Open Source Project
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~      http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License
  -->

<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/notification_background"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" >
    <ImageView android:id="@+id/icon"
        android:layout_width="@dimen/notification_large_icon_width"
        android:layout_height="@dimen/notification_large_icon_height"
        android:scaleType="center"
    />
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="top"
        android:orientation="vertical" >
        <LinearLayout
            android:id="@+id/notification_main_column_container"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="@dimen/notification_large_icon_width"
            android:layout_marginStart="@dimen/notification_large_icon_width"
            android:paddingTop="@dimen/notification_main_column_padding_top"
            android:minHeight="@dimen/notification_large_icon_height"
            android:orientation="horizontal">
            <FrameLayout
                android:id="@+id/notification_main_column"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_marginLeft="@dimen/notification_content_margin_start"
                android:layout_marginStart="@dimen/notification_content_margin_start"
                android:layout_marginBottom="8dp"
                android:layout_marginRight="8dp"
                android:layout_marginEnd="8dp" />
            <FrameLayout
                android:id="@+id/right_side"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginRight="8dp"
                android:layout_marginEnd="8dp"
                android:paddingTop="@dimen/notification_right_side_padding_top">
                <ViewStub android:id="@+id/time"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="end|top"
                    android:visibility="gone"
                    android:layout="@layout/notification_template_part_time" />
                <ViewStub android:id="@+id/chronometer"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="end|top"
                    android:visibility="gone"
                    android:layout="@layout/notification_template_part_chronometer" />
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    android:layout_gravity="end|bottom"
                    android:layout_marginTop="20dp">
                    <TextView android:id="@+id/info"
                        android:textAppearance="@style/TextAppearance.Compat.Notification.Info"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:singleLine="true"
                    />
                    <ImageView android:id="@+id/right_icon"
                        android:layout_width="16dp"
                        android:layout_height="16dp"
                        android:layout_gravity="center"
                        android:layout_marginLeft="8dp"
                        android:layout_marginStart="8dp"
                        android:scaleType="centerInside"
                        android:visibility="gone"
                        android:alpha="0.6"
                    />
                </LinearLayout>
            </FrameLayout>
        </LinearLayout>
        <ImageView
            android:layout_width="match_parent"
            android:layout_height="1px"
            android:id="@+id/action_divider"
            android:visibility="gone"
            android:layout_marginLeft="@dimen/notification_large_icon_width"
            android:layout_marginStart="@dimen/notification_large_icon_width"
            android:background="?android:attr/dividerHorizontal" />
        <LinearLayout
            android:id="@+id/actions"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:visibility=