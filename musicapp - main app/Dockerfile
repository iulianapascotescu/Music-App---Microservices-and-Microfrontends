FROM node:16-alpine
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY ./package.json /app
COPY ./package-lock.json /app
RUN npm install
COPY . .
CMD ["npm", "start"]
