# 03-Homework

Technology stack: JS, HTML5, CSS.

To run the linter, follow these steps:

#### 1. Install nvm if it's needed:

```sh
$ sudo apt-get install build-essential libssl-dev
$ curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.37.2/install.sh | bash
$ source ~/.profile
```

View the list of available versions:

```sh
$ nvm ls-remote
```

#### 2. Install any version:

```sh
$ nvm install v16.13.2
$ nvm use v16.13.2
```

Check your version:

```sh
$ node -v
```

#### 3. Go to project's folder:

```sh
$ cd 03-block/homework
```

#### 4. Install dependencies:

```sh
$ npm install
```

## 5. Run linter

To run tests run the command:
```sh
$ npm run lint
```

## 6. Fix linter errors

To fix linter errors run the command:
```sh
$ npm run lint:fix
```
