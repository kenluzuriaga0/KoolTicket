import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { BranchService } from '../../services/branch.service';

@Component({
  selector: 'app-select-branch',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './select-branch.component.html',
  styleUrl: './select-branch.component.css'
})
export class SelectBranchComponent implements OnInit {

  _branch = inject(BranchService);

  branch_offices = [];

  ngOnInit(): void {
    this._branch.getAllBranches().subscribe((data:any)=>{
        this.branch_offices = data;
    });
  }



}
