import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { BranchService } from '../../../services/branch.service';
import { Sucursal } from '../../../core/domain';

@Component({
  selector: 'app-list-branches',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './list-branches.component.html',
  styleUrl: './list-branches.component.css'
})
export class ListBranchesComponent implements OnInit {

  _branch = inject(BranchService);

  branch_offices:Sucursal[] = [];

  ngOnInit(): void {
    this._branch.getAllBranches().subscribe((data:any)=>{
        this.branch_offices = data;
    });
  }

}
