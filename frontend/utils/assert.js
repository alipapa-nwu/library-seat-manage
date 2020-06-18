module.exports = function(condition, msg = "", log) {
  if (!condition) {
    if(log) console.error(log);
    throw new Error(msg);
  }
}