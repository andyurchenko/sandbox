class OperationExecutor {
  constructor() {
    this.state = {
      0: this.firstTaskExecute,
      1: this.secondTaskExecute,
      2: this.thirdTaskExecute,
      3: this.fourthTaskExecute,
      4: this.fifthTaskExecute,
      5: this.sixthTaskExecute,
      6: this.seventhTaskExecute,
      7: this.eighthTaskExecute,
      8: this.ninthTaskExecute,
      9: this.tenthTaskExecute,
    };
  }

  /**
   * Execute some transformation of incoming arg
   * @param actionType – type of transformation
   * @param arg – incoming arg
   * @returns object with result
   */
  execute(actionType, arg) {
    return this.state[actionType](arg);
  }

  /**
   * First task of homework
   * @param arg – object that you should clone
   * arg = { obj1: { ... } }
   * @returns clone of the arg
   */
  firstTaskExecute = (arg) => {
    const obj1 = { ...arg.obj1 };
    const relativesClonded = arg.obj1.relatives.map((item) => item);
    obj1.relatives = relativesClonded;

    return { obj1 };
  };

  /**
   * Second task of homework
   * @param arg – object with values that you should combine
   * arg = { obj1: { ... }, obj2: { ... } }
   * @returns combination of objects
   */
  secondTaskExecute = (arg) => {
    const newObj = {};
    Object.values(arg).map((item) => Object.assign(newObj, item));
    return newObj;
  };

  /**
   * Third task of homework
   * @param arg – object with value that you should modify
   * arg = { obj1: { ... } }
   * @returns modified object
   */
  thirdTaskExecute = (arg) => {
    const { relatives } = arg.obj1;

    relatives.forEach(
      (item) => {
        if (item.lastName === "Ivanov") {
          item.gender = "male";
        } else {
          item.gender = "female";
        }
      }
    );

    return arg.obj1;
  };

  /**
   * Fourth task of homework
   * @param arg – object with value that contains relatives
   * arg = { obj1: { ... relatives: [ ... ] ... } }
   * @returns modified object
   */
  fourthTaskExecute = (arg) => {
    arg.obj1.greeting = `Hello ${arg.obj1.firstName} ${arg.obj1.lastName}!`;

    const { relatives } = arg.obj1;
    relatives.forEach((relative) => {
      relative.greeting = `Hello ${relative.firstName} ${relative.lastName}!`;
    });

    return arg.obj1;
  };

  /**
   * Fifth task of homework
   * @param arg – object which contains new color of the button
   * and the class of it
   * arg = { color: '...', className: '...' }
   */
  fifthTaskExecute = (arg) => {
    const elements = document.getElementsByClassName(arg.className);
    const collection = Array.from(elements);
    collection.forEach((element) => {
      element.style.backgroundColor = arg.color;
    });
  };

  /**
   * Sixth task of homework
   * @param arg – object with values that you should handle
   * arg = { ... }
   * @returns array of items that match the hostname
   * on which the application is running
   */
  sixthTaskExecute = (arg) => {
    const currentHosts = [];
    const currentHostLocation = window.location.hostname;

    arg.hostNames.forEach((host) => {
      if (host === currentHostLocation) {
        currentHosts.push(host);
      }
    });

    return currentHosts;
  };

  /**
   * Seventh task of homework
   * @param arg – object which contains simple key-value pairs
   * arg = { key: value }
   * @returns obj that contains swap pairs ('value: key')
   */
  seventhTaskExecute = (arg) => {
    const inverseArg = {};
    Object.entries(arg).forEach((item) => {
      const [value, key] = item;
      inverseArg[[key]] = value;
    });
    return inverseArg;
  };

  /**
   * Eighth task of homework
   * @param arg – object which contains two array
   * arg = { ... }
   * @returns obj that built using array's values
   */
  eighthTaskExecute = (arg) => {
    const arr = [...arg.arr1, ...arg.arr2];

    const resultObj = {};
    for (let i = 0; i < arr.length; i += 2) {
      resultObj[arr[i]] = arr?.[i + 1] !== undefined ? arr[i + 1] : null;
    }

    return resultObj;
  };

  /**
   * Ninth task of homework
   * @param arg – object which contains array of users
   * arg = { users: [...] }
   * @returns obj that contains pairs id: obj with this id
   */
  ninthTaskExecute = (arg) => {
    const resultObj = {};

    arg.users.forEach((user) => {
      resultObj[user.id] = user;
    });

    return resultObj;
  };

  /**
   * Tenth task of homework
   * @param arg – object which contains class of item and empty array
   * arg = { key: value }
   * @returns obj that contains the array with info about
   * children of the node and className of that node
   */
  tenthTaskExecute = (arg) => {
    const parent = document.getElementsByClassName(arg.className);
    const children = Array.from(parent[0].children);
    const arr = arg.childrenInfo;
    children.map(
      (element) => arr.push(
        { className: element.className, tagName: element.nodeName }
      )
    );

    return arg;
  };
}

export default OperationExecutor;
