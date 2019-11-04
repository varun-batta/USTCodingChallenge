//
//  ContentView.swift
//  USTCodingChallenge
//
//  Created by Varun Batta on 2019-Nov-03.
//  Copyright © 2019 Varun Batta. All rights reserved.
//

import SwiftUI

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    var cvSectionDescriptors: NSMutableArray!
    var visibleRowsPerSection = [[Int]]()
    
    @IBOutlet var cvTable: UITableView!
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        configureTableView()
        loadCVSectionDescriptors()
    }
    
    func configureTableView() {
        cvTable.delegate = self
        cvTable.dataSource = self
    }
    
    func loadCVSectionDescriptors() {
        if let path = Bundle.main.path(forResource: "CVSectionDescriptor", ofType: "plist") {
            cvSectionDescriptors = NSMutableArray(contentsOfFile: path)
            getIndicesOfVisibleRows()
            cvTable.reloadData()
        }
    }
    
    func getIndicesOfVisibleRows() {
        visibleRowsPerSection.removeAll()
        
        for currentSections in cvSectionDescriptors {
            var visibleRows = [Int]()
            
            for row in 0...((currentSections as! [[String: AnyObject]]).count - 1) {
                if (currentSections as! [[String: AnyObject]])[row]["isVisible"] as! Bool == true {
                    visibleRows.append(row)
                }
            }
            
            visibleRowsPerSection.append(visibleRows)
        }
    }
    
    func getCVSectionDescriptorForIndexPath(indexPath: NSIndexPath) -> [String: AnyObject] {
        let indexOfVisibleRow = visibleRowsPerSection[indexPath.section][indexPath.row]
        let cvSectionDescriptor = (cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfVisibleRow]
        return cvSectionDescriptor
    }
    
    func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        if cvSectionDescriptors != nil {
            return cvSectionDescriptors.count
        }
        else {
            return 0
        }
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return visibleRowsPerSection[section].count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let currentCVSectionDescriptor = getCVSectionDescriptorForIndexPath(indexPath: indexPath as NSIndexPath)
        
        let cell = tableView.dequeueReusableCell(withIdentifier: (currentCVSectionDescriptor["isExpandable"] as! Bool) ? "CVSection" : "CVDetails", for: indexPath as IndexPath) as! CVCell
        cell.setLabel(cvInformation: currentCVSectionDescriptor["value"] as! String)
        
        return cell
    }
    
    private func tableView(tableView: UITableView, cellForRowAt indexPath: NSIndexPath) -> UITableViewCell {
        let currentCVSectionDescriptor = getCVSectionDescriptorForIndexPath(indexPath: indexPath)
        
        let cell = tableView.dequeueReusableCell(withIdentifier: (currentCVSectionDescriptor["isExpandable"] as! Bool) ? "CVSection" : "CVDetails", for: indexPath as IndexPath) as! CVCell
        cell.setLabel(cvInformation: currentCVSectionDescriptor["value"] as! String)
        
        return cell
    }
    
    internal func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let indexOfTappedRow = visibleRowsPerSection[indexPath.section][indexPath.row]
        
        if (cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow]["isExpandable"] as! Bool {
            var shouldExpand = false
            if !((cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow]["isExpanded"] as! Bool) {
                // In this case the cell should expand
                shouldExpand = true
            }
            
            ((cvSectionDescriptors as! [[AnyObject]])[indexPath.section][indexOfTappedRow] as! NSMutableDictionary).setValue(shouldExpand, forKey: "isExpanded")
            
            for i in (indexOfTappedRow + 1)...(indexOfTappedRow + ((cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow]["additionalRows"] as! Int)) {
                ((cvSectionDescriptors as! [[AnyObject]])[indexPath.section][i] as! NSMutableDictionary).setValue(shouldExpand, forKey: "isVisible")
            }
        }
        
        getIndicesOfVisibleRows()
        cvTable.reloadData()
    }
    
    private func tableView(tableView: UITableView, didSelectRowAt indexPath: NSIndexPath) {
        let indexOfTappedRow = visibleRowsPerSection[indexPath.section][indexPath.row]
        
        if (cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow]["isExpandable"] as! Bool {
            var shouldExpand = false
            if !((cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow]["isExpanded"] as! Bool) {
                // In this case the cell should expand
                shouldExpand = true
            }
            
            ((cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow] as! NSMutableDictionary).setValue(shouldExpand, forKey: "isExpanded")
            
            for i in (indexOfTappedRow + 1)...(indexOfTappedRow + ((cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][indexOfTappedRow]["additionalRows"] as! Int)) {
                ((cvSectionDescriptors as! [[[String: AnyObject]]])[indexPath.section][i] as! NSMutableDictionary).setValue(shouldExpand, forKey: "isVisible")
            }
        }
        
        getIndicesOfVisibleRows()
        cvTable.reloadData()
    }
}
