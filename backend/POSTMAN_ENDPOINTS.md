# Colección de pruebas (formato solicitado)

Usa `{{token}}` para el JWT y reemplaza `{id}` por el id correspondiente.

---

# Auth (Login)

## 1. Login
**Método:** POST  
**URL:** `http://localhost:8080/api/auth/login`  
**Headers:**
- Content-Type: application/json

**Body (JSON):**
```json
{
  "username": "admin",
  "password": "admin123"
}
```

**Respuesta exitosa (200) ejemplo:**
```json
{
  "token": "<jwt>",
  "type": "Bearer",
  "id": 1,
  "username": "admin",
  "email": "admin@app.com",
  "role": "ADMIN"
}
```

---

# Gestión de Usuarios

## 1. Obtener todos los usuarios
**Método:** GET  
**URL:** `http://localhost:8080/api/users`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 2. Obtener usuario por ID
**Método:** GET  
**URL:** `http://localhost:8080/api/users/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 3. Crear usuario
**Método:** POST  
**URL:** `http://localhost:8080/api/users`  
**Headers:**
- Authorization: Bearer `{{token}}`  (Debe ser ADMIN)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "username": "nuevoUsuario",
  "password": "Secret123!",
  "email": "usuario@example.com",
  "role": "COORDINADOR",
  "active": true
}
```

---

## 4. Actualizar usuario
**Método:** PUT  
**URL:** `http://localhost:8080/api/users/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (Debe ser ADMIN)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "username": "usuarioActualizado",
  "email": "nuevo@example.com",
  "password": "NuevaPass123!",
  "role": "COORDINADOR",
  "active": false
}
```

---

## 5. Eliminar usuario
**Método:** DELETE  
**URL:** `http://localhost:8080/api/users/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (Debe ser ADMIN)

**Respuesta exitosa (200) ejemplo:**
```json
{
  "message": "Usuario eliminado exitosamente"
}
```

---

# Gestión de Categorías

## 1. Obtener todas las categorías
**Método:** GET  
**URL:** `http://localhost:8080/api/categories`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 2. Obtener categoría por ID
**Método:** GET  
**URL:** `http://localhost:8080/api/categories/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 3. Crear categoría
**Método:** POST  
**URL:** `http://localhost:8080/api/categories`  
**Headers:**
- Authorization: Bearer `{{token}}`  (ADMIN o COORDINADOR)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "name": "Electrónica",
  "description": "Teléfonos, ordenadores y accesorios",
  "active": true
}
```

---

## 4. Actualizar categoría
**Método:** PUT  
**URL:** `http://localhost:8080/api/categories/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (ADMIN o COORDINADOR)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "name": "Electrónica y Gadgets",
  "description": "Smartphones, tablets, accesorios",
  "active": true
}
```

---

## 5. Eliminar categoría
**Método:** DELETE  
**URL:** `http://localhost:8080/api/categories/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (Debe ser ADMIN)

**Respuesta exitosa (200) ejemplo:**
```json
{
  "message": "categoria eliminada con exito"
}
```

---

# Gestión de Subcategorías

## 1. Obtener todas las subcategorías
**Método:** GET  
**URL:** `http://localhost:8080/api/subcategories`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 2. Obtener subcategorías por categoría
**Método:** GET  
**URL:** `http://localhost:8080/api/subcategories/category/{categoryId}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 3. Obtener subcategoría por ID
**Método:** GET  
**URL:** `http://localhost:8080/api/subcategories/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 4. Crear subcategoría
**Método:** POST  
**URL:** `http://localhost:8080/api/subcategories`  
**Headers:**
- Authorization: Bearer `{{token}}`  (ADMIN o COORDINADOR)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "name": "Smartphones",
  "description": "Teléfonos móviles inteligentes",
  "category": { "id": 10 },
  "active": true
}
```

---

## 5. Actualizar subcategoría
**Método:** PUT  
**URL:** `http://localhost:8080/api/subcategories/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (ADMIN o COORDINADOR)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "name": "Smartphones y Accesorios",
  "description": "Teléfonos y accesorios",
  "active": true
}
```

---

## 6. Eliminar subcategoría
**Método:** DELETE  
**URL:** `http://localhost:8080/api/subcategories/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (Debe ser ADMIN)

**Respuesta exitosa (200) ejemplo:**
```json
{
  "message": "Subcategoría eliminada exitosamente"
}
```

---

# Gestión de Productos

## 1. Obtener todos los productos
**Método:** GET  
**URL:** `http://localhost:8080/api/products`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 2. Obtener productos por categoría
**Método:** GET  
**URL:** `http://localhost:8080/api/products/category/{categoryId}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 3. Obtener productos por subcategoría
**Método:** GET  
**URL:** `http://localhost:8080/api/products/subcategory/{subcategoryId}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 4. Obtener producto por ID
**Método:** GET  
**URL:** `http://localhost:8080/api/products/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`

---

## 5. Crear producto
**Método:** POST  
**URL:** `http://localhost:8080/api/products`  
**Headers:**
- Authorization: Bearer `{{token}}`  (ADMIN o COORDINADOR)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "name": "iPhone 14",
  "description": "Teléfono Apple iPhone 14, 128GB",
  "price": 899.99,
  "stock": 50,
  "category": { "id": 10 },
  "subcategory": { "id": 101 },
  "active": true
}
```

---

## 6. Actualizar producto
**Método:** PUT  
**URL:** `http://localhost:8080/api/products/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (ADMIN o COORDINADOR)
- Content-Type: application/json

**Body (JSON):**
```json
{
  "price": 849.99,
  "stock": 45,
  "active": true
}
```

---

## 7. Eliminar producto
**Método:** DELETE  
**URL:** `http://localhost:8080/api/products/{id}`  
**Headers:**
- Authorization: Bearer `{{token}}`  (Debe ser ADMIN)

**Respuesta exitosa (200) ejemplo:**
```json
{
  "message": "Producto eliminado exitosamente"
}
```

---

# Estadísticas

## 1. Obtener estadísticas
**Método:** GET  
**URL:** `http://localhost:8080/api/stats`  
**Headers:**
- Authorization: Bearer `{{token}}`

**Respuesta (ejemplo):**
```json
{
  "categories": 5,
  "subcategories": 17,
  "products": 230,
  "users": 12
}
```

---

# Nota final
- Reemplaza `{{token}}` por el JWT válido obtenido del login.  
- Reemplaza `{id}`, `{categoryId}`, `{subcategoryId}`, `{productId}` por los ids reales obtenidos al crear recursos.
- Usa `Content-Type: application/json` en requests con body JSON.
- Solo `ADMIN` puede eliminar usuarios/categorías/subcategorías/productos; `COORDINADOR` puede listar, crear y actualizar según controladores.

