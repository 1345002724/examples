Date.prototype.format=function (fmt){
  let rs= fmt.replace("yyyy",this.getFullYear());
  let mm='00'+(this.getMonth()+1);
  rs =rs.replace("MM",mm.substr(mm.length-2,mm.length));
     mm='00'+this.getDate();
    rs =rs.replace("dd",mm.substr(mm.length-2,mm.length));
    mm='00'+this.getHours();
    rs =rs.replace("HH",mm.substr(mm.length-2,mm.length));
    mm='00'+this.getMinutes();
    rs =rs.replace("mm",mm.substr(mm.length-2,mm.length));
    mm='00'+this.getSeconds();
    rs =rs.replace("ss",mm.substr(mm.length-2,mm.length));
    return rs;
}
