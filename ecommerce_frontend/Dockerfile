# Stage 1: Build the Angular application
FROM node:22.5.1 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --configuration=production && ls -la /app/dist/ecommerce_frontend

# Stage 2: Serve the application with Nginx
FROM nginx:alpine
COPY --from=build /app/dist/ecommerce_frontend/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
