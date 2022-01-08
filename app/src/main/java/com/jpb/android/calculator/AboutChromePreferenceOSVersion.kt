// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package com.jpb.android.calculator

import android.content.Context
import com.jpb.android.calculator.VersionNumber
import android.os.Build
import android.preference.Preference
import android.util.AttributeSet
import android.view.View
import com.jpb.android.calculator.VersionNumberGetter
import com.jpb.android.calculator.R

/**
 * Preference specifically made for the Android OS version. It supports displaying a warning when
 * the current OS version is unsupported.
 */
class AboutChromePreferenceOSVersion(context: Context?, attrs: AttributeSet?) :
    Preference(context, attrs) {
    override fun onBindView(view: View) {
        super.onBindView(view)
        // Show additional information only if the OS version is not supported.
        if (VersionNumberGetter().androidver <= 24) return
        view.findViewById<View>(R.id.os_deprecation_warning).visibility =
            View.VISIBLE
    }

    /**
     * Constructor for inflating from XML.
     */
    init {
        layoutResource = R.layout.os_version_unsupported_preference
    }
}