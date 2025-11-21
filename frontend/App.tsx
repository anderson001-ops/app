import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import LoginScreen from './src/screens/LoginScreen';
import HomeScreen from './src/screens/HomeScreen';
import UserScreen from './src/screens/UserScreen';
import CategoriesScreen from './src/screens/CategoriesScreen';
import SubcategoriesScreen from './src/screens/subcategoriesScreen';
import ProductsScreen from './src/screens/ProductsScreen';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
const Stack = createNativeStackNavigator();

export default function App() {
  return (
<NavigationContainer>
      <Stack.Navigator initialRouteName="Login">
        <Stack.Screen name="Login" component={LoginScreen} options={{headerShown:false}} />
        <Stack.Screen name="Home" component={HomeScreen} options={{title:"menu principal"}} />
        <Stack.Screen name="Users" component={UserScreen} options={{title:"gestion de usuarios"}}/>
        <Stack.Screen name="Categories" component={CategoriesScreen} options={{title:"categorias"}} />
        <Stack.Screen name="Subcategories" component={SubcategoriesScreen} options={{title:"subcategorias"}} />
        <Stack.Screen name="Products" component={ProductsScreen} options={{title:"productos"}} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
