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
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Second task of homework
   * @param arg – object with values that you should combine
   * arg = { obj1: { ... }, obj2: { ... } }
   * @returns combination of objects
   */
  secondTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Third task of homework
   * @param arg – object with value that you should modify
   * arg = { obj1: { ... } }
   * @returns modified object
   */
  thirdTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Fourth task of homework
   * @param arg – object with value that contains relatives
   * arg = { obj1: { ... relatives: [ ... ] ... } }
   * @returns modified object
   */
  fourthTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Fifth task of homework
   * @param arg – object which contains new color of the button and the class of it
   * arg = { color: '...', className: '...' }
   */
  fifthTaskExecute = (arg) => {
    /**
     * Place your code here
     */
  };

  /**
   * Sixth task of homework
   * @param arg – object with values that you should handle
   * arg = { ... }
   * @returns array of items that match the hostname on which the application is running
   */
  sixthTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Seventh task of homework
   * @param arg – object which contains simple key-value pairs
   * arg = { key: value }
   * @returns obj that contains swap pairs ('value: key')
   */
  seventhTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Eighth task of homework
   * @param arg – object which contains two array
   * arg = { ... }
   * @returns obj that built using array's values
   */
  eighthTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Ninth task of homework
   * @param arg – object which contains array of users
   * arg = { users: [...] }
   * @returns obj that contains pairs id: obj with this id
   */
  ninthTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };

  /**
   * Tenth task of homework
   * @param arg – object which contains class of item and empty array
   * arg = { key: value }
   * @returns obj that contains the array with info about
   * children of the node and className of that node
   */
  tenthTaskExecute = (arg) => {
    /**
     * Place your code here
     */
    return null;
  };
}

export default OperationExecutor;
