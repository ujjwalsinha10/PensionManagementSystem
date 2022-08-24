import { Component, OnInit } from '@angular/core';
import { ProcessPensionService } from 'src/app/services/process-pension.service';

@Component({
  selector: 'app-pensioner-list',
  templateUrl: './pensioner-list.component.html',
  styleUrls: ['./pensioner-list.component.css']
})
export class PensionerListComponent implements OnInit {
  pensionerList=[
    {
      aadhaarNumber:'',
      name:'',
      dateOfBirth:null,
      salary:null,
      allowance:null,
      panNumber:'',
      pensionType:'',
      bankDetail:{
        accountNumber: '',
        bankName: '',
        bankType: ''
      }
    },
    
  ];
  // bankDetail:any=[{
  //   accountNumber: '',
  //   bankName: '',
  //   bankType: ''
  // },];
  


  constructor(private pensionService:ProcessPensionService ) { }

  ngOnInit(): void {
    this.pensionService.getAllPensioner().subscribe(data=>{
      console.log(data);
      // this.pensionerList=data;
      // this.bankDetail=data.bankDetail;
      console.log(data.length);
      for(var i=0; i<data.length;i++){
        var dob=data[i].dateOfBirth;
        var trim=dob.substring(0,10);
        data[i].dateOfBirth=trim;
      }
      this.pensionerList=data;
      
      
    },(error=>{
      console.log(error);
    }))
  }

}
