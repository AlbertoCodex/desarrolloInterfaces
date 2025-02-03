package com.example.composeavanzado.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class DataFirebase(
    val auth: FirebaseAuth,
    val db: FirebaseFirestore
)