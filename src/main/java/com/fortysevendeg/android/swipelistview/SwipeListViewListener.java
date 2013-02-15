/*
 * Copyright (C) 2013 47 Degrees, LLC
 * http://47deg.com
 * hello@47deg.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fortysevendeg.android.swipelistview;

public interface SwipeListViewListener {

    void onOpened(int position, boolean toRight);

    void onClosed(int position, boolean fromRight);

    void onListChanged();

    void onMove(int position, float x);

    void onClickFrontView(int position);

    void onClickBackView(int position);

    void onDismiss(int[] reverseSortedPositions);

}