var mongoose = require('mongoose');
var Schema = mongoose.Schema;

// Define collection and schema for Items
var Person = new Schema({
  name: {
    type: String
  },
  age: {
    type: Number
  }
},{
    collection: 'persons'
});

module.exports = mongoose.model('Person', Person);