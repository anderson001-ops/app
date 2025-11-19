import React,{ useEffect, useState } from 'react';
import { View, Text, FlatList, TouchableOpacity,Alert,TextInput,Modal,ActivityIndicator ,StyleSheet,ScrollView } from 'react-native';
import{categoriesStyles} from '../styles/CategoriesStyles';
import {categoryServices,authServices} from '../services/api';
 
export default function CategoriesScreen() {
    const [categories, setCategories] = useState<any[]>([]);
    const [loading, setLoading] = useState(false);
    const[modalvisible,setModalvisible]=useState(false);
    const[editing,setEditing]=useState<any>(null);
    const[formData,setFormData]=useState({name:'',description:''});
    const[error,setError]=useState('');
    const [currentUser, setCurrentUser] = useState<any>(null);

    useEffect(() => {
        loadCurrentUser();
        loadCategories();
    }, []);

    const loadCurrentUser=async()=>{
        try{
            const user = await authServices.getCurrentUser();
            setCurrentUser(user);
    }catch(error){
        console.error('Error al cargar usuarios ', error);
    }
    };
    
    const loadCategories = async () => {
        setLoading(true);
        setError('');
        try {
            const response = await categoryServices.getAll();
            setCategories(response.data || []);
        } catch (error) {setError('Error al cargar categorias');
            setCategories([]);
        } finally {
            setLoading(false);
        }
    };
    const resetForm=()=>{
        setFormData({name:'',description:''});
        setEditing(null);
    };

    const handlesave=async()=>{
        if(!formData.name.trim()){
            Alert.alert("error","El nombre es obligatorio");
            return;
        }
        try{
            if(editing){
                await categoryServices.update(editing.id,formData);
                Alert.alert("exito","Categoria actualizada");

            } else {
                await categoryServices.create(formData);
                Alert.alert("exito","Categoria creada");
            }
            setModalvisible(false);
            resetForm();
            loadCategories();
        }catch(error){
            Alert.alert("error","no se puede guardar");
        }
    };

    const handleDelete=(item:any)=>{
        if (currentUser?.role !== 'admin') {
            Alert.alert('acceso denegado', 'solo administradores pueden eliminar categorias');
            return;
        }
        Alert.alert("confiar","¿eliminar ${item.name}?",[   
            {text:"cancelar",style:"cancel"},
            {text:"eliminar",
            style:"destructive",
            onPress:async()=>{
                try{
                }
            }
        ]);
    };
}