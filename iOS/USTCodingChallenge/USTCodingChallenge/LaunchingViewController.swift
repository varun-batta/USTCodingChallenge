//
//  LaunchingViewController.swift
//  USTCodingChallenge
//
//  Created by Varun Batta on 2019-Nov-03.
//  Copyright © 2019 Varun Batta. All rights reserved.
//

import UIKit

class LaunchingViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        Timer.scheduledTimer(timeInterval: 1, target: self, selector: #selector(self.splashTimeOut(sender:)), userInfo: nil, repeats: false)
        // Do any additional setup after loading the view.
    }
    
    @objc func splashTimeOut(sender: Timer) {
        let mySceneDelegate = self.view.window?.windowScene?.delegate as! SceneDelegate
        let storyboard = UIStoryboard.init(name: "LaunchScreen", bundle: nil)
        let targetViewController = storyboard.instantiateViewController(identifier: "CV")
        mySceneDelegate.changeView(viewController: targetViewController)
    }
}
