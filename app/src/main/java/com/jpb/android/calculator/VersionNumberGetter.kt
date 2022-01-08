// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package com.jpb.android.calculator

import com.jpb.android.calculator.VersionNumber
import android.os.Build
import com.jpb.android.calculator.VersionNumberGetter
import com.jpb.android.calculator.R

/**
 * Stubbed class for getting version numbers from the rest of Chrome.  Override the functions for
 * unit tests.
 */
class VersionNumberGetter {
    var androidver = Build.VERSION.SDK_INT
}